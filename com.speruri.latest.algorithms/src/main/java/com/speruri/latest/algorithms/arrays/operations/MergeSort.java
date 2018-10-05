package com.speruri.latest.algorithms.arrays.operations;

public class MergeSort {

	public static void mergeSort(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}
		if (low > high) {
			return;
		}

		// Find the mid point
		int mid = (low + high) / 2;
		// Make two arrays, left (low to mid) and right (mid+1 to high)
		int[] left = new int[mid - low];
		int[] right = new int[high - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		int k = 0;
		for (int j = mid; j < high; j++, k++) {
			right[k] = a[j];
		}

		// call merge sort on both the left and right
		mergeSort(left, low, mid);
		mergeSort(right, mid + 1, high);
		// Finally merge those two sorted arrays
		mergeArrays(left,right,a);
	}

	private static void mergeArrays(int[] left, int[] right, int[] a) {
		// TODO Auto-generated method stub
		
	}


}
