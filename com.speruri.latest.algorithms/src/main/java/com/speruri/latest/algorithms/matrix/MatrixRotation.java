package com.speruri.latest.algorithms.matrix;

public class MatrixRotation {

	public static void printMatrixInspiralSpiral(int[][] a, int top, int bottom, int left, int right) {

		if (left > right) {
			return;
		}

		for (int i = left; i <= right; i++) {
			System.out.print(a[top][i] + " ");
		}
		top++;

		if (top > bottom) {
			return;
		}

		for (int i = top; i <= bottom; i++) {
			System.out.print(a[i][right] + " ");
		}
		right--;

		if (left > right) {
			return;
		}
		for (int i = right; i >= left; i--) {
			System.out.print(a[bottom][i] + " ");
		}
		bottom--;

		if (top > bottom) {
			return;
		}

		for (int i = bottom; i >= top; i--) {
			System.out.print(a[i][left] + " ");
		}
		left++;
		printMatrixInspiralSpiral(a, top, bottom, left, right);
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		int top = 0;
		int bottom = 2;
		int left = 0;
		int right = 5;

		printMatrixInspiralSpiral(a, top, bottom, left, right);
	}

}
