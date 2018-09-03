package com.speruri.latest.algorithms.sorting;

public class QuickSort {

	public void quickSort(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}

		if (low < high) {
			int partition = partition(a, low, high);
			quickSort(a, low, partition - 1);
			quickSort(a, partition + 1, high);
		}

	}

	public int partition(int[] a, int low, int high) {
		if (a == null || a.length == 0 || low < 0 || high < 0) {
			return -1;
		}
		int pivot = a[high];
		int j = low - 1;

		for (int i = low; i < high; i++) {
			if (a[i] <= pivot) {
				CustomArrayUtils.swap(a, i, ++j);
			}
		}
		CustomArrayUtils.swap(a, j + 1, high);
		return j + 1;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(arr, 0, n - 1);
		CustomArrayUtils.printArray(arr);
	}

}
