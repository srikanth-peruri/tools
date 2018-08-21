package com.speruri.spring.main;

import java.io.IOException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Solution {

	static void miniMaxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		long min = 0;
		long max = 0;

		for (int i = 0; i < arr.length; i++) {
			long currentSum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					// skip the sum
				} else {
					currentSum += arr[j];
				}
			}
			if (min == 0 || currentSum < min) {
				min = currentSum;
			}
			if (max == 0 || currentSum > max) {
				max = currentSum;
			}
		}

		System.out.println(min + " " + max);

	}

	static void staircase(int n) {
		if (n < 0) {
			return;
		}
		int length = n;

		for (int i = 0, j = length - 1; i < length; i++, j--) {
			int c = length - 1;
			while (c >= 0) {
				if (c <= i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
				c--;
			}
			System.out.println();
		}

	}

	static void plusMinus(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		int length = arr.length;

		float positiveCount = 0;
		float negativeCount = 0;
		float zeroCount = 0;

		for (int i = 0; i < length; i++) {
			int current = arr[i];

			if (current > 0) {
				// positive
				positiveCount++;
			} else if (current < 0) {
				// negative
				negativeCount++;
			} else {
				// zeros
				zeroCount++;
			}
		}

		System.out.printf("%.6f", positiveCount / length);
		System.out.println();

		System.out.printf("%.6f", negativeCount / length);
		System.out.println();

		System.out.printf("%.6f", zeroCount / length);
		System.out.println();

	}

	// Complete the diagonalDifference function below.
	static int diagonalDifference(int[][] arr) {
		int rowsLength = arr[0].length - 1;
		int columnsLength = arr[1].length - 1;
		if (rowsLength != columnsLength) {
			return 0;
		}

		int leftToRightDiagonalSum = 0;
		int rightToLeftDiagonalSum = 0;

		for (int rows = 0, columns = columnsLength; rows <= rowsLength; rows++, columns--) {
			int x = arr[rows][rows];
			System.out.println(x);
			leftToRightDiagonalSum += x;
			int y = arr[rows][columns];
			System.out.println(y);
			rightToLeftDiagonalSum += y;
		}

		return Math.abs(leftToRightDiagonalSum - rightToLeftDiagonalSum);
	}

	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */
		if (s == null || s.length() < 2) {
			return null;
		}

		String hrStr = s.charAt(0) + "" + (s.charAt(1) != ':' ? s.charAt(1) : "");
		if (hrStr.length() < 2) {
			hrStr = "0" + hrStr;
		}
		char ampm = s.charAt(s.length() - 2);

		System.out.println(hrStr);

		try {
			// 1.40 PM
			int hrNum = Integer.valueOf(hrStr);
			hrNum = hrNum % 12;
			if (ampm == 'p' || ampm == 'P') {
				hrNum = 12 + hrNum;
			}
			hrStr = String.valueOf(hrNum);
			if (hrStr.length() < 2) {
				hrStr = "0" + hrStr;
			}
			char[] newHR = new char[s.length() - 2];
			for (int i = 0; i < s.length() - 2; i++) {
				if (i < 2) {
					newHR[i] = (hrStr.charAt(i));
				} else {
					newHR[i] = s.charAt(i);
				}
			}

			s = new String(newHR);
		} catch (Exception e) {
			throw new RuntimeException("Exceptio : ", e);
		}

		return s;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		int[][] arr = new int[3][3];
//		arr[0][0] = 11;
//		arr[0][1] = 2;
//		arr[0][2] = 4;
//		arr[1][0] = 4;
//		arr[1][1] = 5;
//		arr[1][2] = 6;
//		arr[2][0] = 10;
//		arr[2][1] = 8;
//		arr[2][2] = -12;
//
//		System.out.println(diagonalDifference(arr));
//
//		int[] a = new int[] { -4, 3, -9, 0, 4, 1 };
//		plusMinus(a);

		staircase(4);

		miniMaxSum(new int[] { 1, 3, 5, 7, 9 });

		System.out.println(timeConversion("12:40:22AM"));
	}
}
