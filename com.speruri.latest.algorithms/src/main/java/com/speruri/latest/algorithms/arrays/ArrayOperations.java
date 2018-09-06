package com.speruri.latest.algorithms.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class ArrayOperations {

	// For rotating the array, we simply take 2 pointers.
	// low and high
	// simply access the first and last and then swap
	// O(n) complexity
	public static void rotateArray(int a[]) {
		if (a == null || a.length == 0) {
			return;
		}
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			CustomArrayUtils.swap(a, low, high);
			low++;
			high--;
		}
	}

	// For this we can first copy the d elements into the temp array
	// and then shift the elements to its left position and finally add the d
	// elements to the right of the aray
	// O(n*d)
	public static void rotateByNumber(int[] a, int d) {
		if (a == null || a.length == 0 || d <= 0) {
			return;
		}

		// copy into temp array
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i];
		}

		// now shift the elements from right to left
		for (int i = 0; i < d; i++) {
			int l = 0;
			while (l < a.length - 1) {
				a[l] = a[l + 1];
				l++;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			a[a.length - d + i] = temp[i];
		}

	}

	// This is kadane's algorith to find the max sum of the continous sub array
	// O(n)
	public static int[] maxSumForContinousSubArrayUsingKadane(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		int maxSoFar = 0;
		int maxEnd = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < a.length; i++) {
			maxEnd += a[i];
			if (maxEnd < 0) {
				maxEnd = 0;
				s = i + 1;
			}
			if (maxSoFar < maxEnd) {
				maxSoFar = maxEnd;
				start = s;
				end = i;
			}
		}
		System.out.println("Found the indexes as :  start : " + start + " end : " + end);
		int[] temp = new int[end - start + 1];
		for (int i = start, j = 0; i <= end; i++, j++) {
			temp[j] = a[i];
		}
		return temp;
	}

	public static void rotateArray(int[] a, int d) {
		if (a == null || a.length == 0 || d < 0) {
			return;
		}

		int count = d;
		int t = 0;
		int i = 0;
		boolean done = false;
		int[] temp = new int[a.length];

		while (!done) {
			temp[i++] = a[count++ % a.length];
			t++;
			if (t == a.length) {
				done = true;
			}
		}

		for (int j = 0; j < temp.length; j++) {
			System.out.print(temp[j] + " ");
		}

	}

	private static Stack<Integer> stack = new Stack<Integer>();
	private static int maxElement = Integer.MIN_VALUE;

	public static void handleOperation(String operation) {
		if (operation == null || operation.isEmpty()) {
			return;
		}

		String[] operations = operation.split(" ");
		if (operations != null) {

			int op1 = Integer.valueOf(operations[0]);
			int op2 = -1;
			if (operations.length > 1) {
				op2 = Integer.valueOf(operations[1]);
			}

			switch (op1) {
			case 1:
				stack.push(op2);
				if (op2 > maxElement) {
					maxElement = op2;
				}
				break;
			case 2:
				int e = stack.pop();
				if (e == maxElement) {
					maxElement = e;
				}
				break;
			case 3:
				System.out.println(maxElement);
				break;
			default:
				System.out.println("Enter valid operation");
				break;
			}
		}

	}

	public static int euclidGcd(int dividend, int divisor) {
		if (divisor == 0)
			return dividend;
		int remainder = dividend % divisor;
		return euclidGcd(divisor, remainder);
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		rotateArray(a);
		CustomArrayUtils.printArray(a);
		rotateArray(a);
		rotateByNumber(a, 2);
		System.out.println("Rotated array");
		CustomArrayUtils.printArray(a);
		int b[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Max sum is of continous sub array is ");
		CustomArrayUtils.printArray(maxSumForContinousSubArrayUsingKadane(b));
		int[] ra = { 1, 2, 3, 4, 5 };
		System.out.println("Rotation");
		rotateArray(ra, 4);
		System.out.println("GCD");

		System.out.println(euclidGcd(400, 124));
	
		System.out.println((int)'a');
	}
	
}
