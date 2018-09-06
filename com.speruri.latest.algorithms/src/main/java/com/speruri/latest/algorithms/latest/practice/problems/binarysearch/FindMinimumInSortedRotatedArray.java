package com.speruri.latest.algorithms.latest.practice.problems.binarysearch;

public class FindMinimumInSortedRotatedArray {

	public static int findMin(int[] a, int l, int h) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int value = -1;

		int low = 0;
		int high = a.length - 1;
		// {5, 6, 7, 8, 9, 1, 2, 3, 4}
		while (low <= high) {
			int mid = (low + high) / 2;
			int prev = (mid - 1 + a.length) % a.length;
			int next = (mid + 1) % a.length;
			int midElement = a[mid];
			if (midElement < a[prev] && midElement < a[next]) {
				return mid;
			} else if (midElement < a[high]) {
				if (midElement <= a[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {

				low = mid + 1;
			}

		}

		return value;
	}

	public static int findTheExtraItemInSortedArrays(int[] a, int[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0) {
			return -1;
		}

		int index = -1;

		// left and right are end
		// points denoting the current range.
		int left = 0, right = b.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;

			// If middle element is same
			// of both arrays, it means
			// that extra element is after
			// mid so we update left to mid+1
			if (a[mid] == b[mid])
				left = mid + 1;

			// If middle element is different
			// of the arrays, it means that
			// the index we are searching for
			// is either mid, or before mid.
			// Hence we update right to mid-1.
			else {
				index = mid;
				right = mid - 1;
			}
		}

		// when right is greater than
		// left, our search is complete.
		return index;
	}

	static int findRepeatingElement(int arr[], int low, int high) {
		// low = 0 , high = n-1;
		if (low > high)
			return -1;

		int mid = (low + high) / 2;

		// Check if the mid element is the repeating one
		int midValue = arr[mid];
		if (midValue != mid + 1) {
			if (mid > 0 && midValue == arr[mid - 1])
				return mid;

			// If mid element is not at its position that means
			// the repeated element is in left
			return findRepeatingElement(arr, low, mid - 1);
		}

		// If mid is at proper position then repeated one is in
		// right.
		return findRepeatingElement(arr, mid + 1, high);
	}

	public static void main(String[] args) {

		// int arr1[] = { 5, 6, 1, 2, 3, 4 };
		// int n1 = arr1.length;
		// System.out.println("The minimum element is " + findMin(arr1, 0, n1 -
		// 1));
		//
		// int arr2[] = { 1, 2, 3, 4 };
		// int n2 = arr2.length;
		// System.out.println("The minimum element is " + findMin(arr2, 0, n2 -
		// 1));
		//
		// int arr3[] = { 1 };
		// int n3 = arr3.length;
		// System.out.println("The minimum element is " + findMin(arr3, 0, n3 -
		// 1));
		//
		// int arr4[] = { 1, 2 };
		// int n4 = arr4.length;
		// System.out.println("The minimum element is " + findMin(arr4, 0, n4 -
		// 1));
		//
		// int arr5[] = { 2, 1 };
		// int n5 = arr5.length;
		// System.out.println("The minimum element is " + findMin(arr5, 0, n5 -
		// 1));
		//
		// int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
		// int n6 = arr6.length;
		// System.out.println("The minimum element is " + findMin(arr6, 0, n1 -
		// 1));
		//
		// int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
		// int n7 = arr7.length;
		// System.out.println("The minimum element is " + findMin(arr7, 0, n7 -
		// 1));
		//
		// int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
		// int n8 = arr8.length;
		// System.out.println("The minimum element is " + findMin(arr8, 0, n8 -
		// 1));
		//
		// int arr9[] = { 3, 4, 5, 1, 2 };
		// int n9 = arr9.length;
		// System.out.println("The minimum element is " + findMin(arr9, 0, n9 -
		// 1));

//		int arr1[] = { 2, 4, 6, 8, 10, 12, 13 };
//		int arr2[] = { 2, 4, 5, 6, 8, 10, 12, 13 };
//		// Solve is passed both findTheExtraItemInSortedArrays
//		System.out.println(findTheExtraItemInSortedArrays(arr1, arr2));

		int arr[] = { 10, 12, 13, 14, 15, 16, 16, 17 };
		int index = findRepeatingElement(arr, 0, arr.length - 1);
		if (index != -1)
			System.out.println(arr[index]);
	}
}