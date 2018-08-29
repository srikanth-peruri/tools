package com.speruri.latest.algorithms.sorting;

public class Bubblesort {

	public static int[] performBubblesort(int[] a) {
		if (a == null || a.length == 0) {
			return a;
		}

		// Swaps the items by comparing the ith and ith + 1 in every pass
		// for (int i = 0; i < a.length - 1; i++) {
		// for (int j = i, k = j + 1; k < a.length; k++, j++) {
		// if (a[j] < a[k]) {
		// int temp = a[k];
		// a[k] = a[j];
		// a[j] = temp;
		// }
		// }
		// }

		// 64, 25, 12, 22, 11
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		return a;
	}

	public static void main(String[] args) {
		int[] a = Bubblesort.performBubblesort(new int[] {64, 34, 25, 12, 22, 11, 90});
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
