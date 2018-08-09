package com.speruri.latest.algorithms.arrays;

public class ArrayLeftShfting {

	enum SHIFT {
		right, left
	}
                      
	public static int[] shiftelement(int[] array, int count, SHIFT shift) {
		for (int i = 0; i < count; i++) {
			if (shift.equals(SHIFT.left)) {
				leftShiftByOne(array);
			} else if (shift.equals(SHIFT.right)) {
				rightShiftByOne(array);
			}
		}
		return array;
	}

	public static int[] leftShiftByOne(int[] array) {
		// Shift the array elements by one. We first read the first element a[0]
		// then just traverse the array and assign the next element to the
		// previous element
		// this is to be done till array.length- 2; since we need to swap the
		// last element as well
		int temp = array[0];
		int i = 1;
		for (i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[i] = temp;
		return array;
	}

	public static int[] rightShiftByOne(int[] array) {
		int temp = array[array.length - 1];

		int i = array.length - 1;

		for (; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[i] = temp;
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		shiftelement(array, 2, SHIFT.left);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		shiftelement(array, 2, SHIFT.right);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}
}
