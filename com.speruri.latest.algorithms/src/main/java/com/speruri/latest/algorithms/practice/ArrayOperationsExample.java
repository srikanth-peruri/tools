package com.speruri.latest.algorithms.practice;

import java.util.Map;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class ArrayOperationsExample {

	public static void findPairWithSum(int[] a, int sum) {
		if (a == null || a.length == 0) {
			return;
		}

		Map<Integer, Integer> map = new java.util.HashMap();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(sum - a[i])) {
				System.out.println("SUm found at : " + i + " and " + map.get(sum - a[i]));
			}
			map.put(a[i], i);
		}
	}

	public static void shiftBinary(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int i = 0;
		int j = 0;
		for (i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				CustomArrayUtils.swap(a, i, j);
				j = j + 1;
			}
		}

	}

	public static int findDuplicate(int a[]) {
		if (a == null || a.length == 0) {
			return -1;
		}

		Map<Integer, Integer> map = new java.util.HashMap();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}

		for (Integer key : map.keySet()) {
			Integer x = map.get(key);
			if (x > 1) {
				System.out.println(key);
			}
		}

		return -1;
	}

	public static void findMaxSumOfCountinousSubArrayOfLengthK(int[] a, int k) {
		// If the length of the sub array is given and wanted to find the sub
		// array with max sum , then we should use windlow sliding algo
		// In the same way if the length of the sub array is not givena dn asked
		// to find the length of the sub array with max sum , then we should use
		// Kadane's algorithm
		if (a == null || a.length == 0 || k > a.length) {
			return;
		}

		// CAlculate the max sum for the first k elements
		int maxSoFar = 0;
		for (int i = 0; i < k; i++) {
			maxSoFar += a[i];
		}
		// Now assign the max sum to a new variable
		int start = -1;
		int windowMax = maxSoFar;
		for (int i = k; i < a.length; i++) {
			windowMax += a[i] - a[i - k];
			if (windowMax > maxSoFar) {
				maxSoFar = windowMax;
				start = i - k + 1;
			}
		}

		System.out.println("Max total is : " + maxSoFar + " at " + start + " to : " + (start + k - 1));
	}

	public static void findLargestSumContinousSubarray(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int maxEndSum = 0;
		int maxSoFar = 0;
		int start = -1;
		int end = -1;
		int s = 0;

		for (int i = 0; i < a.length; i++) {
			maxEndSum += a[i];
			if (maxEndSum < 0) {
				maxEndSum = 0;
				s = i + 1;
			}
			if (maxEndSum > maxSoFar) {
				maxSoFar = maxEndSum;
				end = i;
				start = s;
			}
		}

		int[] temp = new int[end - start + 1];
		for (int j = start, k = 0; j <= end; j++, k++) {
			temp[k] = a[j];
		}
		CustomArrayUtils.printArray(temp);
		System.out.println("sub array from : " + start + "  end " + end + " is : " + maxSoFar);
		System.out.println("Max sum : " + maxSoFar);

	}

	public static void main(String[] args) {
		int a[] = { 8, 7, 2, 5, 3, 1 };
		findPairWithSum(a, 10);
		int b[] = { 0, 1, 0, 1, 0, 1, 0, 1, 0 };
		shiftBinary(b);
		CustomArrayUtils.printArray(b);

		int c[] = { 8, 7, 7, 2, 5, 3, 1, 1 };
		System.out.println("Duplicate item is");
		System.out.println(findDuplicate(c));

		int[] d = { 2, 0, 2, 1, 4, 3, 0, 1 };
		findLargestSumContinousSubarray(d);
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		findMaxSumOfCountinousSubArrayOfLengthK(arr, k);
	}

}
