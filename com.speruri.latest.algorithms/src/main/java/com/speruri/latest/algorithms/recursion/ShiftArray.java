package com.speruri.latest.algorithms.recursion;

public class ShiftArray {

	public static int[] shiftArray(int[] array, int count) {
		if (array != null && array.length > 0) {
			for (int i = 0; i < count; i++) {
				rotateByOne(array);
			}
		}
		return array;
	}

	public static void rotateByOne(int[] array) {
		int temp = array[0];
		int i = 0;
		for (i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[i] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };

		int[] reverseArray = ShiftArray.shiftArray(array, 2);
		for (int i = 0; i < reverseArray.length; i++) {
			System.out.print(reverseArray[i]);
			if (i != reverseArray.length - 1) {
				System.out.print(" ");
			}
		}
	}

}
