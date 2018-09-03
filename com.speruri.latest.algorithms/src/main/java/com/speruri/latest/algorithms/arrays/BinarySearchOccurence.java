package com.speruri.latest.algorithms.arrays;

public class BinarySearchOccurence {

	public static int findFirstOccurenceInArray(int a[], int x) {
		int result = -1;
		if (a == null || a.length == 0) {
			return result;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				result = mid;
				// If we want to search for the first index of the element, then
				// assign the high to mid - 1
				// high = mid - 1;
				// If we need to find the last element, then assign low to the
				// mid + 1
				low = mid + 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 10, 10, 10, 18, 20 };
		System.out.println(findFirstOccurenceInArray(a, 10));
	}
}
