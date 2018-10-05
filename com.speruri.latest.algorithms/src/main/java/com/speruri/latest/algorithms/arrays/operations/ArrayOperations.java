package com.speruri.latest.algorithms.arrays.operations;

public class ArrayOperations {

	public static void largestSumContinousArray(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int maxSum = 0;
		int endSum = 0;
		int start = -1;
		int end = -1;
		int s = -1;

		for (int i = 0; i < a.length; i++) {
			endSum += a[i];
			if (endSum < 0) {
				endSum = 0;
				s = i + 1;
			}

			if (endSum > maxSum) {
				maxSum = endSum;
				start = s;
				end = i;
			}
		}
		System.out.println("MAx sum is : " + maxSum + " from : " + start + " to " + end);
	}

	public static void minAvg(int[] a, int k) {
		if (a == null || a.length == 0) {
			return;
		}
	}

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		largestSumContinousArray(a);
	}
}
