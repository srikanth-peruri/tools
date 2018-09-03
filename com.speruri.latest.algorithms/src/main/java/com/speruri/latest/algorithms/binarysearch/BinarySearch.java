package com.speruri.latest.algorithms.binarysearch;

public class BinarySearch {

	public int binarySearch(int[] list, int itemToFind) {

		int first = 0;
		int last = list.length - 1;

		while (first <= last) {
			int mid = (first + last) / 2;
			int midItem = list[mid];

			if (midItem == itemToFind) {
				return mid;
			} else if (itemToFind > midItem) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearhInRecursion(int[] a, int x, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		if (a[mid] == x) {
			return mid;
		} else if (x < a[mid]) {
			high = mid - 1;
		} else if (x > a[mid]) {
			low = mid + 1;
		}
		return binarySearhInRecursion(a, x, low, high);
	}

	public static int findFirstOccurenceOfNumber(int a[], int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;
		int index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]) {
				index = mid;
				high = mid - 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			}
		}
		return index;
	}

	public static int findLastOccurenceOfNumber(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int index = -1;

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]) {
				index = mid;
				low = mid + 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			}
		}

		return index;
	}

	public static int countNoOfOccurences(int a[], int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int firstOccurence = findFirstOccurenceOfNumber(a, x);
		int lastOccurence = findLastOccurenceOfNumber(a, x);
		return (lastOccurence - firstOccurence + 1);
	}

	public static int noOftimesRotated(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			if (a[low] < a[high]) {
				return low;
			}
			int mid = (low + high) / 2;
			int next = (mid + 1) % a.length;
			int prev = (mid - 1 + a.length) % a.length;

			// {12,34,56,65,1,2,3}
			if (a[mid] <= a[prev] && a[mid] <= a[next]) {
				return mid;
			} else if (a[mid] <= a[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int findElementInCircularlySortedArray(int a[], int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int low = 0;
		int high = a.length - 1;
		// {12,13,14,2,3}
		// x=2
		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]) {
				return mid;
			} else if (a[low] <= a[mid]) {
				if (a[low] <= x && x < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (a[mid] <= a[high]) {
				if (a[mid] < x && x <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		// int[] list = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
		// };
		int[] list = { 1, 3, 5, 7, 9 };
		int itemToFind = 3;
		int itemFoundAt = binarySearch.binarySearch(list, itemToFind);
		System.out.println("Item Found at : " + itemFoundAt);
		System.out.println("Recursiong");

		int[] a = { 0, 1, 2, 5, 5, 5, 5, 5, 8, 9, 10, 11, 12, 13, 14, 15 };
		System.out.println(binarySearhInRecursion(a, 15, 0, a.length - 1));

		System.out.println();
		System.out.println("First index found at : " + findFirstOccurenceOfNumber(a, 5));
		System.out.println();
		System.out.println("Last index found at : " + findLastOccurenceOfNumber(a, 5));
		System.out.println();
		System.out.println("No of occurences : " + countNoOfOccurences(a, 5));
		System.out.println();
		int[] rlist = { 10, 11, 12, 12, 1, 3, 5, 7, 9 };

		System.out.println("No of occurences : " + noOftimesRotated(rlist));

		System.out.println();
		System.out.println("Search in circularly sorted array : " + findElementInCircularlySortedArray(rlist, 10));

	}
}
