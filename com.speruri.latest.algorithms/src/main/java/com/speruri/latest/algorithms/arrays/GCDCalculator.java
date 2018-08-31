package com.speruri.latest.algorithms.arrays;

public class GCDCalculator {

	static int calculateGCD(int[] a) {
		int result = 0;
		if (a == null || a.length == 0) {
			return 0;
		}

		result = a[0];

		for (int i = 1; i < a.length; i++) {
			result = gcd(a[i], result);
		}

		return result;
	}

	static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		int divisor = a;
		int dividend = b;
		int remainder = dividend % divisor;
		return gcd(remainder, divisor);
	}

	public static void main(String[] args) {
		System.out.println(calculateGCD(new int[] { 16, 8 }));
	}
}
