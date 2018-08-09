package com.speruri.latest.algorithms.arrays;

public class SearchInRotatedSortedArray {

	static int searchInSortedRotatedArray(int[] a, int number) {
		int index = -1;
		if (a == null || a.length == 0) {
			return index;
		}

		int pivot = -1;

		for (int i = 0; i < a.length - 2; i++) {
			int item = a[i];
			int nextItem = a[i + 1];
			if (nextItem < item) {
				pivot = i;
				break;
			}
		}

		if (pivot == -1) {
			return binarySearch(a, number, 0, a.length - 1);
		}

		if (number == a[pivot]) {
			return pivot;
		} else if (a[0] > number) {
			return binarySearch(a, number, pivot, a.length - 1);
		}
		return binarySearch(a, number, 0, pivot);
	}

	static int binarySearch(int[] a, int number, int argStart, int argEnd) {
		int index = -1;
		if (a == null || a.length == 0 || argStart > argEnd) {
			return index;
		}
		int start = argStart;
		int end = argEnd;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midelement = a[mid];
			if (number == midelement) {
				return mid;
			} else if (number > midelement) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 5, 6, 7, 1, 2 };
		System.out.println(searchInSortedRotatedArray(array, 4));

		// for (int i = 0; i < array.length; i++) {
		// System.out.print(array[i] + " ");
		// }
	}
}
