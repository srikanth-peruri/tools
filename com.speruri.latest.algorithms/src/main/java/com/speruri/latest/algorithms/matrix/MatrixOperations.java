package com.speruri.latest.algorithms.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class MatrixOperations {

	public static void printLowerMatrix(int[][] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int rowSize = a.length;
		int colSize = a[0].length;

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (i < j) {
					System.out.print(0 + " ");
				} else {
					System.out.print(a[i][j] + " ");
				}
			}
		}
	}

	public static void printUpperMatrix(int[][] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int rowSize = a.length;
		int colSize = a[0].length;

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (j < i) {
					System.out.print(0 + " ");
				} else {
					System.out.print(a[i][j] + " ");
				}
			}
		}
	}

	public static void multiplyMatrices(int[][] src1, int[][] src2, int[][] dest) {
		if (src1 == null || src1.length == 0 || src2 == null || src2.length == 0 || src1.length != src2.length
				|| dest == null) {
			return;
		}

		int src1numRows = src1.length;
		int src1numCols = src1[0].length;

		for (int i = 0; i < src1numRows; i++) {
			for (int j = 0; j < src1numCols; j++) {
				dest[i][j] = 0;
				for (int k = 0; k < src1numCols; k++) {
					dest[i][j] += src1[i][k] * src1[k][j];
				}
			}
		}
	}

	public static void sortMatrixElements(int[][] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int rowsSize = a.length;
		int colSize = a[0].length;
		int k = 0;
		int[] temp = new int[rowsSize * colSize];

		for (int i = 0; i < rowsSize; i++) {
			for (int j = 0; j < colSize; j++) {
				temp[k++] = a[i][j];
			}
		}

		mergeSort(temp);
		// quickSort(temp, 0, temp.length - 1);
		System.out.println("After quicksort");
		k = 0;
		for (int i = 0; i < rowsSize; i++) {
			for (int j = 0; j < colSize; j++) {
				a[i][j] = temp[k++];
			}
		}

	}

	private static void mergeSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int len = a.length;
		if (len < 2) {
			return;
		}

		int mid = len / 2;
		int[] left = new int[mid];
		int[] right = new int[len - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for (int i = mid, j = 0; i < len; i++, j++) {
			right[j] = a[i];
		}

		mergeSort(left);
		mergeSort(right);
		mergeSortedArrays(left, right, a);
	}

	private static void mergeSortedArrays(int[] left, int[] right, int[] a) {
		if (left == null || right == null || a == null) {
			return;
		}

		int leftIndex = 0;
		int rightIndex = 0;
		int leftLength = left.length;
		int rightLength = right.length;
		int actualIndex = 0;

		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (left[leftIndex] < right[rightIndex]) {
				a[actualIndex] = left[leftIndex];
				leftIndex++;
			} else {
				a[actualIndex] = right[rightIndex];
				rightIndex++;
			}
			actualIndex++;
		}

		while (leftIndex < leftLength) {
			a[actualIndex] = left[leftIndex];
			leftIndex++;
			actualIndex++;
		}

		while (rightIndex < rightLength) {
			a[actualIndex] = right[rightIndex];
			rightIndex++;
			actualIndex++;
		}

	}

	public static void quickSort(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}
		if (low < high) {
			int partition = partition(a, low, high);
			quickSort(a, low, partition - 1);
			quickSort(a, partition + 1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int j = low - 1;

		for (int i = low; i < high; i++) {
			if (a[i] < pivot) {
				j++;
				CustomArrayUtils.swap(a, i, j);
			}
		}
		CustomArrayUtils.swap(a, j + 1, high);
		return j + 1;
	}

	public static void transpose(int[][] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int numRows = a.length;
		int numcols = a[0].length;

		for (int i = 0; i < numRows; i++) {
			for (int j = numcols - 1; j >= 0; j--) {
				if (i + 1 < numRows && j - 1 >= 0) {
					int temp = a[i][j - 1];
					a[i][j - i] = a[i + 1][j];
					a[i + 1][j] = temp;
				}
			}
		}
	}

	public static void arrayUnionIntersection(int a[], int[] b) {
		if (a == null || a.length == 0 | b == null || b.length == 0) {
			return;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		for (int i = 0; i < b.length; i++) {
			set.add(b[i]);
		}
		
		
		System.out.println("Union array : ");
		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println("Array Intersection ");
		for (Integer integer : (b.length < a.length ? b : a)) {
			if (set.contains(integer)) {
				System.out.print(integer + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printLowerMatrix(matrix);
		System.out.println();
		printUpperMatrix(matrix);
		System.out.println("Matrix multiplication");
		int mat1[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };

		int mat2[][] = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
		int dest[][] = new int[4][4];
		multiplyMatrices(mat1, mat2, dest);
		CustomArrayUtils.print2DArray(dest);

		System.out.println("Matrix sort \n");
		int mat[][] = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		sortMatrixElements(mat);
		CustomArrayUtils.print2DArray(mat);
		System.out.println();

		System.out.println("Matrix Transpose \n");
		int mat3[][] = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 } };
		transpose(mat3);
		CustomArrayUtils.print2DArray(mat3);
		System.out.println();

		System.out.println("Array union and intersection");
		arrayUnionIntersection(new int[] { 1, 3, 4, 5, 7 }, new int[] { 2, 3, 5, 6 });

	}
}
