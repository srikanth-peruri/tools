package com.speruri.latest.algorithms.divideandconquer;

public class DivideandConquerOperations {

	public static int binarySearch(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int findNoOfRotations(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		// 12,13,14,2,3,4,5
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			// Check whether the low element is less than high elemtn,
			// then the array is no rotated and we can return the index of low
			if (a[low] < a[high]) {
				return low;
			}

			int mid = (low + high) / 2;
			int prev = (mid - 1 + a.length) % a.length;
			int next = (mid + 1) % a.length;
			if (a[mid] <= prev && a[mid] <= next) {
				return mid;
			} else if (a[mid] <= a[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int findElementInCircularlySortedArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		// 9, 10, 2, 5, 6, 8
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] <= a[high]) {
				if (x >= a[mid] && x <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (x >= a[low] && x <= a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public enum INDEX {
		FIRST, LAST
	}

	public static int findIndexSortedArray(int[] a, int x, INDEX index) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				result = mid;
				if (index == INDEX.FIRST) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (x < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	public static int findMaxOccurences(int a[], int x) {
		int first = findIndexSortedArray(a, x, INDEX.FIRST);
		int last = findIndexSortedArray(a, x, INDEX.LAST);
		return (last - first + 1);
	}

	public static int findSmallestMissingNumber(int[] a, int low, int high) {
		if (low > high) {
			return low;
		}

		int mid = (low + high) / 2;
		if (a[mid] == mid) {
			return findSmallestMissingNumber(a, mid + 1, high);
		} else {
			return findSmallestMissingNumber(a, low, mid - 1);
		}
	}

	public static class FloorAndCeil {
		int floorIndex = -1;
		int ceilIndex = -1;

	}

	public static FloorAndCeil findfloorAndCeil(int[] a, int x) {
		if (a == null || a.length == 0) {
			return null;
		}
		int low = 0;
		int high = a.length - 1;
		FloorAndCeil f = new FloorAndCeil();

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				f.floorIndex = mid;
				f.ceilIndex = mid;
				return f;
			} else if (x < a[mid]) {
				f.ceilIndex = mid;
				high = mid - 1;
			} else {
				f.floorIndex = mid;
				low = mid + 1;
			}
		}
		return f;
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 9, 10, 15, 16 };
		System.out.println("Item found at : " + binarySearch(a, 2));
		int[] b = { 12, 13, 14, 15, 16, 2, 3, 4, 5 };
		System.out.println("no of rotations : " + findNoOfRotations(b));
		int[] c = { 9, 10, 2, 5, 6, 8 };
		System.out.println("Found at index  : " + findElementInCircularlySortedArray(c, 9));
		int[] d = { 2, 5, 5, 5, 5, 6, 6, 8, 9, 9, 9, 9, 9 };
		System.out.println("Max occurences : " + findMaxOccurences(d, 9));
		int[] e = { 0, 1, 2, 4, 5, 6 };
		System.out.println("Smallest Missing : " + findSmallestMissingNumber(e, 0, e.length - 1));
		int[] f = { 1, 4, 6, 8, 9 };
		for (int i = 0; i <= 10; i++) {
			FloorAndCeil floor = findfloorAndCeil(f, i);
			System.out.println("Number is : " + i + "Floor : " + floor.floorIndex + " ceil : " + floor.ceilIndex);
		}
	}

}
