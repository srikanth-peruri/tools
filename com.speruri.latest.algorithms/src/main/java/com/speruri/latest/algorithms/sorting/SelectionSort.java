package com.speruri.latest.algorithms.sorting;

public class SelectionSort {
	// Tis iterates the array and put the minimum element at the first. And then
	// take the next element and search the whole array for the least elemen
	// and then push the element into second place and so on.

	public static int[] performSelectionSort(int[] a) {
		if (a == null || a.length == 0) {
			return a;
		}
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}

			int temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}

		return a;
	}

	public static void main(String[] args) {
		int[] a = SelectionSort.performSelectionSort(new int[] { 64, 25, 12, 22, 11 });
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
