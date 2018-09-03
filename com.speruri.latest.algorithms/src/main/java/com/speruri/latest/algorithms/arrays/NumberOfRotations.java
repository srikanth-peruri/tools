package com.speruri.latest.algorithms.arrays;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class NumberOfRotations {

	public static int findRotationCount(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		// While low < high
		while (low < high) {
			// If the element at high is greater that element at low, then we
			// can say its sorted and no rotations.
			// Simply return the low index;
			if (a[low] <= a[high]) {
				return low;
			}

			// Now calculate the mid point
			int mid = (low + high) / 2;
			// Get the previous element
			int prev = (mid - 1 + a.length) % a.length;
			// Get the next element
			int next = (mid + 1) % a.length;

			// There will be only element which will be lesser than both prev
			// and next, that is what we need to find
			// This is nothing but the pivot
			if (a[mid] <= a[prev] && a[mid] <= a[next]) {
				return mid;
			} else if (a[mid] < a[high]) {
				// Then we can say that array is sorted and we can discard the
				// elements mid to right
				high = mid - 1;
			} else if (a[mid] >= a[low]) {
				// If the element at mid is greater than the low element, then
				// we can discard the first half since its sorted
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 15, 18, 2, 3, 6, 12 };
		System.out.println(findRotationCount(arr));
	}

}
