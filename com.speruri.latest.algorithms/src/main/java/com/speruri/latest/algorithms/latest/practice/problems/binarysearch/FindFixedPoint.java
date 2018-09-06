package com.speruri.latest.algorithms.latest.practice.problems.binarysearch;

public class FindFixedPoint {

	public static int findFixedPointInArray(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int midValue = a[mid];
			if (midValue == mid) {
				return mid;
			} else if (midValue > mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { -10, -1, 0, 3, 10, 11, 30, 50, 100 };
		int n = arr.length;
		System.out.println("Fixed Point is " + findFixedPointInArray(arr));
	}
}
