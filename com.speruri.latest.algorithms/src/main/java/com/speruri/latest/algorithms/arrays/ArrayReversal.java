package com.speruri.latest.algorithms.arrays;

public class ArrayReversal {

	// call the recursive functoin untill the start and end are equal
	// It takes O(n/2) -> O(n)
	static void reverseArray(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
		start++;
		end--;
		reverseArray(array, start, end);
	}

	static int getreversedElementWithOOf1(int[] array, int index) {
		if (index > array.length - 1) {
			return -1;
		}
		int newIndex = (array.length - 1) - index;
		return array[newIndex];
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		reverseArray(array, 0, array.length - 1);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println();
		array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(getreversedElementWithOOf1(array, 7));
	}
}
