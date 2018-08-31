package com.speruri.latest.algorithms.arrays;

public class Fibonacci {

	// O(n)
	static int fibWithRecursion(int n) {
		if (n <= 1) {
			return n;
		}
		return fibWithRecursion(n - 1) + fibWithRecursion(n - 2);
	}

	// O(n)
	static int fibWithVariables(int n) {
		if (n <= 0) {
			return 0;
		}

		int a = 0;
		int b = 1;
		int c = 0;

		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}

		return c;
	}

	static int fibMatrixMultiplication(int n) {
		if (n <= 0) {
			return 0;
		}

		int[][] F = new int[][] { { 1, 1 }, { 1, 0 } };
		power(F, n);
		return F[0][0];
	}

	// O(logn)

	private static void power(int[][] F, int n) {

		int[][] M = new int[][] { { 1, 1 }, { 1, 0 } };

		for (int j = 2; j < n; j++) {
			multiply(F, M);
		}
	}

	private static void multiply(int[][] F, int[][] M) {
		int w = (F[0][0] * M[0][0]) + (F[0][1] * M[1][0]);
		int x = (F[0][0] * M[0][1]) + (F[0][1] * M[1][1]);
		int y = (F[1][0] * M[0][0]) + (F[1][1] * M[1][0]);
		int z = (F[1][1] * M[0][1]) + (F[1][1] * M[1][1]);

		F[0][0] = w;
		F[0][1] = x;
		F[1][0] = y;
		F[1][1] = z;
	}

	public static void main(String[] args) {
		System.out.println("Fib with rec : " + fibWithRecursion(9));
		System.out.println("Fib with variables " + fibWithVariables(9));
		System.out.println("Fib with variables " + fibMatrixMultiplication(9));
	}
}
