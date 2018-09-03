package com.speruri.latest.algorithms.arrays;

public class BinarySearchOperations {

	private enum POSITION {
		first, last
	}

	public static int performBinarySearch(int[] a, int x) {
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

	public static int findNoOfRotationsInCircularlyRotatedArray(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;
		int result = -1;
		// Since its a ciprcularly rotated array, we can check whether the mid
		// point matches with the searched int or not.
		// If yes, then we will return that.
		// Or else, we will calculate the prev and next of the mid and see
		// whether the mid is lesser than both the prev and next.
		// This is the only item which contains this property. I mean this would
		// the lesser that prev and next.
		// {3,4,5,6,7,1,2}
		while (low <= high) {

			// Check if the first element is lesser than the last element, then
			// we could that the array is already sorted with 0 rotations
			int highE = a[high];
			int lowE = a[low];
			if (lowE < highE) {
				return low;
			}

			int mid = (low + high) / 2;

			// Also, we need to calculate the prev and next element to the mid.
			// so that we can check the mid is lesser than both the low and high
			// if yes, then we would return that index since thats the only
			// element where its lesser than both the low and high. The index of
			// it is nothing but the no of rotations
			// { 6, 12, 15, 18, 2, 3 };
			int prev = (mid - 1 + a.length) % a.length;
			int next = (mid + 1) % a.length;

			int midE = a[mid];
			int prevE = a[prev];
			int nextE = a[next];
			if (midE <= prevE && midE <= nextE) {
				return mid;
			} else if (midE <= highE) {
				high = mid - 1;
			} else if (midE >= lowE) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int findFirstOccurenceOfElementInCircularlyRotatedArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		// { 2, 4, 10, 10, 10, 18, 20, 21 };
		int low = 0;
		int high = a.length - 1;
		int result = -1;

		while (low <= high) {
			// calculate the mid point and check.
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				result = mid;
				high = mid - 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			}
		}

		return result;
	}

	public static int findLastOccurenceOfElementInCircularlyRotatedArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		// { 2, 4, 10, 10, 10, 18, 20, 21 };
		int low = 0;
		int high = a.length - 1;
		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				result = mid;
				low = mid + 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			}
		}

		return result;
	}

	public static int findFirstOrLastOccurenceOfElementInCircularlyRotatedArray(int[] a, int x, POSITION pos) {
		if (a == null || a.length == 0) {
			return -1;
		}
		// { 2, 4, 10, 10, 10, 18, 20, 21 };
		int low = 0;
		int high = a.length - 1;
		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == a[mid]) {
				result = mid;
				if (pos == POSITION.first) {
					high = mid - 1;
				} else if (pos == POSITION.last) {
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

	public static int findCountOfOccurencesInSortedArray(int a[], int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int firstOccuredat = findFirstOccurenceOfElementInCircularlyRotatedArray(a, x);
		int lastOccuredat = findLastOccurenceOfElementInCircularlyRotatedArray(a, x);
		return (lastOccuredat - firstOccuredat + 1);
	}

	public static int findNoOfrorationsInCircularlySortedArray(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			if (a[low] <= a[high]) {
				return low;
			}

			int mid = (low + high) / 2;

			int prev = (mid - 1 + a.length) % a.length;
			int next = (mid + 1) % a.length;

			if (a[mid] <= a[prev] && a[mid] <= a[next]) {
				return mid;
			} else if (a[mid] <= a[high]) {
				high = mid - 1;
			} else if (a[mid] >= a[low]) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int searchInSortedCircularlyRotatedArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		// iterate the whole array untill the low < high
		int low = 0;
		int high = a.length - 1;
		// 12,14,18,21,3,6,8,9
		while (low <= high) {
			int mid = (low + high) / 2;

			if (x == a[mid]) {
				return mid;
			} else if (a[low] <= a[mid]) {
				if (x >= a[low] && x <= a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (a[mid] <= a[high]) {
				if (x >= a[mid] && x <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	public static void printElementsInSpriralOrder(int[][] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int numRows = a.length;
		int numCols = a[0].length;

		// These are the top and left
		int T = 0;
		int B = numRows - 1;
		int L = 0;
		int R = numCols - 1;

		int i = 0;
		int dir = 0;

		while (T <= B && L <= R) {
			if (dir == 0) {
				for (i = T; i <= R; i++) {
					System.out.print(a[T][i] + " ");
				}
				T++;
			} else if (dir == 1) {
				for (i = T; i <= B; i++) {
					System.out.print(a[i][R] + " ");
				}
				R--;
			} else if (dir == 2) {
				for (i = R; i >= L; i--) {
					System.out.print(a[B][i] + " ");
				}
				B--;
			} else if (dir == 3) {
				for (i = B; i >= T; i--) {
					System.out.print(a[i][L] + " ");
				}
				L++;
			}
			dir = (dir + 1) % a[0].length;
		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 10, 10, 10, 18, 20, 21 };
		System.out.println(performBinarySearch(a, 21));
		int[] marray = { 6, 12, 15, 18, 2, 3 };
		System.out.println(findNoOfRotationsInCircularlyRotatedArray(marray));
		System.out.println("First occured at : " + findFirstOccurenceOfElementInCircularlyRotatedArray(a, 10));
		System.out.println("Last occured at : " + findLastOccurenceOfElementInCircularlyRotatedArray(a, 10));
		System.out.println(
				"Last occured at : " + findFirstOrLastOccurenceOfElementInCircularlyRotatedArray(a, 10, POSITION.last));
		System.out.println("Count of occurences in a sorted array : " + findCountOfOccurencesInSortedArray(a, 10));
		int[] ca = { 11, 12, 2, 3, 5, 8 };
		System.out.println("No of rotations " + findNoOfrorationsInCircularlySortedArray(ca));
		int[] rArray = { 12, 14, 18, 21, 3, 6, 8, 9 };
		System.out.println("Rotated sorted array found at :" + searchInSortedCircularlyRotatedArray(rArray, 8));
		int mat[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 },
				{ 19, 20, 21, 22, 23, 24 } };
		printElementsInSpriralOrder(mat);
	}

}
