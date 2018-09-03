package com.speruri.latest.algorithms.sorting;

public class SelectionSort {
	// Tis iterates the array and put the minimum element at the first. And then
	// take the next element and search the whole array for the least elemen
	// and then push the element into second place and so on.

	public static void performSelectionSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			CustomArrayUtils.swap(a, i, minIndex);
		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 64, 25, 12, 22, 11 };
		SelectionSort.performSelectionSort(a);
		CustomArrayUtils.printArray(a);
	}
}
