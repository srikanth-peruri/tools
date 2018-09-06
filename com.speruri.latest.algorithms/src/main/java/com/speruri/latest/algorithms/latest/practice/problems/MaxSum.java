package com.speruri.latest.algorithms.latest.practice.problems;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class MaxSum {

	// Given an array, we should find the max sum from the array
	// Use Kadane's alg to get the max sum
	// Takes O(n)

	public static int getMaxSum(int[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int maxResult = 0;
		int endresult = 0;

		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < a.length; i++) {
			endresult = endresult + a[i];
			if (endresult < 0) {
				endresult = 0;
				s = i + 1;
			}

			if (maxResult < endresult) {
				maxResult = endresult;
				start = s;
				end = i;
			}
		}

		System.out.println("Foudn the indexes at : " + start + "  " + end);

		return maxResult;
	}

	public static int maxSumOfElementsWithSize(int[] a, int k) {
		if (a == null || a.length == 0) {
			return 0;
		}

		int maxSum = 0;
		int windowSum = 0;

		for (int i = 0; i < k; i++) {
			maxSum += a[i];
		}

		windowSum = maxSum;
		for (int i = k; i < a.length; i++) {
			windowSum += a[i] - a[i - k];
			if (maxSum < windowSum) {
				System.out.println("Max sum for elements : " + (i) + " " + (i - k + 1) + " total : " + windowSum);
				maxSum = windowSum;
			}
		}

		return maxSum;
	}

	public static int maxProfit(int a[]) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		int j = -1;
		int buyDay = -1;
		int sellDay = -1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < minPrice) {
				minPrice = a[i];
				j = i;
			} else if (a[i] - a[j] > maxProfit) {
				maxProfit = a[i] - a[j];
				buyDay = j + 1;
				sellDay = i + 1;
			}
		}
		System.out.println("Max profit is on days : Buy day " + buyDay + " Sell day " + sellDay);
		return maxProfit;
	}

	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] prod = new int[nums.length];

		left[0] = 1;
		right[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			prod[i] = left[i] * right[i];
		}

		return prod;
	}

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int maxSum = 0;
		int endSum = 0;
		int negativeSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			endSum = endSum + nums[i];
			if (endSum < 0) {
				if (negativeSum < endSum) {
					negativeSum = endSum;
				}
				endSum = 0;
			}

			if (maxSum < endSum) {
				maxSum = endSum;
			}

		}
		if (maxSum == 0) {
			maxSum = negativeSum;
		}
		return maxSum;

	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int max_sum = getMaxSum(a);
		System.out.println("Maximum contiguous sum is " + max_sum);
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		System.out.println("Maximum sum is " + maxSumOfElementsWithSize(arr, k));
		int[] diff = new int[] { 7, 1, 5, 3, 6, 4 };

		System.out.println("Max diff : " + maxProfit(diff));
		CustomArrayUtils.printArray(productExceptSelf(new int[] { 10, 3, 5, 6, 2 }));
		System.out.println(maxSubArray(new int[] { -2, -1 }));
		java.util.List<Integer> list = new java.util.ArrayList();
		java.util.Queue<Integer> q = new java.util.ArrayDeque();
		
	}

}
