package com.speruri.latest.algorithms.sorting;

//In this merhge sort, we divide the array into two halves and then continue dividing them till we have only one element
//One elment in array is always sorted
//Then we compare the elements and merge them back in sorted way
//This is O(nlogn) algorithm which is much faster than Selection, bubble and insertion sorts
//But it takes O(n) space
//Its a recursive call

public class MergeSort {

	public void mergeSort(int[] a) {
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

		for (int i = mid, j = 0; i < a.length; i++, j++) {
			right[j] = a[i];
		}

		mergeSort(left);
		mergeSort(right);
		mergeArraysInSorted(left, right, a);

	}

	private void mergeArraysInSorted(int[] left, int[] right, int[] a) {
		if (a == null || left == null || right == null) {
			return;
		}
		int leftLength = left.length;
		int rightLength = right.length;

		int lIndex = 0;
		int rIndex = 0;
		int arIndex = 0;

		// Take two pointers for the arrays and then move them accordingly
		while (lIndex < leftLength && rIndex < rightLength) {
			if (left[lIndex] < right[rIndex]) {
				a[arIndex] = left[lIndex];
				lIndex++;
			} else {
				a[arIndex] = right[rIndex];
				rIndex++;
			}
			arIndex++;
		}

		while (lIndex < leftLength) {
			a[arIndex] = left[lIndex];
			arIndex++;
			lIndex++;
		}

		while (rIndex < rightLength) {
			a[arIndex] = right[rIndex];
			arIndex++;
			rIndex++;
		}

	}


	public static void main(String[] args) {
		int[] a = {12, 11, 13, 5, 6, 7}; 
		MergeSort mergeSort = new MergeSort();
		System.out.println("Before Sorting");
		CustomArrayUtils.printArray(a);
		mergeSort.mergeSort(a);
		System.out.println("\nAfter Sorting");
		CustomArrayUtils.printArray(a);
	}

}
