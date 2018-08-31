package com.speruri.latest.algorithms.strings;

public class WindowSlidingProblem {

	static int maxCount(int[] a, int k) {
		int maxSum = 0;

		if (a.length < k) {
			return -1;
		}

		// Iterate the first k chars and assume thats the max sum of the window

		for (int i = 0; i < k; i++) {
			maxSum += a[i];
		}

		// Now iterate the other element and then add the next element and
		// subtract the previous element
		int windowMax = maxSum;
		for (int i = k; i < a.length; i++) {
			windowMax = windowMax - a[i - k] + a[i];
			maxSum = Math.max(windowMax, maxSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		System.out.println(maxCount(arr, k));
	}
}
