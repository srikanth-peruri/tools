package com.speruri.latest.algorithms.sorting;

public class SortingAlgorithms {

	public static void performSelectionSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		// for (int i = 0; i < a.length - 1; i++) {
		// int minIndex = i;
		// for (int j = i + 1; j < a.length; j++) {
		// if (a[i] < a[minIndex]) {
		// minIndex = j;
		// }
		// }
		// CustomArrayUtils.swap(a, minIndex, i);
		// }

		int j;
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			j = i + 1;
			while (j < a.length) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
				j++;
			}
			CustomArrayUtils.swap(a, i, minIndex);
		}
	}

	public static void performBubbleSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					CustomArrayUtils.swap(a, j, j + 1);
				}
			}
		}

	}

	public static void performQuicksort(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}
		if (low < high) {
			int pivotIndex = partition(a, low, high);
			performQuicksort(a, low, pivotIndex - 1);
			performQuicksort(a, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int j = low - 1;
		int pivot = a[high];

		for (int i = 0; i < a.length; i++) {
			if (a[i] < pivot) {
				j++;
				CustomArrayUtils.swap(a, i, j);
			}
		}
		CustomArrayUtils.swap(a, j + 1, high);
		return j + 1;
	}

	public static void mergeSort(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}
		int length = a.length;

		if (length < 2) {
			return;
		}

		int mid = length / 2;
		int[] left = new int[mid];
		int[] right = new int[length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int i = mid, j = 0; i < length; i++, j++) {
			right[j] = a[i];
		}
		mergeSort(left, low, mid - 1);
		mergeSort(right, mid + 1, high);
		mergeSortedArrays(left, right, a);
	}

	private static void mergeSortedArrays(int[] left, int[] right, int[] a) {
		int leftindex = 0;
		int rightIndex = 0;
		int actualIndex = 0;

		while (leftindex < left.length && rightIndex < right.length) {
			if (left[leftindex] < right[rightIndex]) {
				a[actualIndex] = left[leftindex++];
			} else {
				a[actualIndex] = right[rightIndex++];
			}
			actualIndex++;
		}

		while (leftindex < left.length) {
			a[actualIndex] = left[leftindex++];
			actualIndex++;
		}

		while (rightIndex < right.length) {
			a[actualIndex] = right[rightIndex++];
			actualIndex++;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 64, 25, 12, 22, 11 };
		System.out.println("Selection Sort");
		SelectionSort.performSelectionSort(a);
		CustomArrayUtils.printArray(a);
		System.out.println();
		System.out.println("Bubble Sort");
		int[] arr = new int[] { 64, 25, 12, 22, 11 };
		performBubbleSort(arr);
		CustomArrayUtils.printArray(arr);
		System.out.println();
		System.out.println("Quick Sort");
		int[] qarr = new int[] { 64, 25, 12, 22, 11 };
		performBubbleSort(qarr);
		CustomArrayUtils.printArray(qarr);

		System.out.println();
		System.out.println("Merge Sort");
		// int[] marr = new int[] { 64, 25, 12, 22, 11 };
		int[] marr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		mergeSort(marr, 0, marr.length - 1);
		CustomArrayUtils.printArray(marr);

	}
}
