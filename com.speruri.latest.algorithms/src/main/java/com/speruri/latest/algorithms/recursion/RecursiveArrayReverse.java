package com.speruri.latest.algorithms.recursion;

public class RecursiveArrayReverse {

	public static int[] reverseArray(int[] array, int start, int end) {
		if (start > end) {
			return array;
		}
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
		reverseArray(array, ++start, --end);
		return array;
	}

	public static int factorial(int n) {
		if (n < 2) {
			return n;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int[] reverseArray = RecursiveArrayReverse.reverseArray(array, 0, array.length - 1);
		for (int i = 0; i < reverseArray.length; i++) {
			System.out.print(reverseArray[i]);
			if (i != reverseArray.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println(RecursiveArrayReverse.factorial(6));
	}
}
