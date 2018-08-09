package com.speruri.latest.algorithms.recursion;

public class ArrayReverse {

	public static int[] reverseArray(int[] array) {
		int length = array.length - 1;
		int count = 0;
		for (int i = 0; i < (array.length / 2); i++) {
			int index = length - i;
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
			++count;
		}
		System.out.println("Completed in " + count + " Iterations");
		return array;
	}

	public static String reverseString(String str) {
		StringBuilder reversedString = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			reversedString.append(ch);
		}
		return reversedString.toString();
	}

	public static String getBinaryString(int number) {
		String bin = "";
		int modifiedNumber = number;
		while (modifiedNumber > 0) {
			bin = modifiedNumber % 2 + bin;
			modifiedNumber = modifiedNumber / 2;
		}
		return bin;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int[] reverseArray = ArrayReverse.reverseArray(array);
		for (int i = 0; i < reverseArray.length; i++) {
			System.out.print(reverseArray[i]);
			if (i != reverseArray.length - 1) {
				System.out.print(",");
			}
		}

		reverseArray = ArrayReverse.reverseArray(reverseArray);
		for (int i = 0; i < reverseArray.length; i++) {
			System.out.print(reverseArray[i]);
			if (i != reverseArray.length - 1) {
				System.out.print(",");
			}
		}

		System.out.println();
		System.out.println("Reversed String is : " + ArrayReverse.reverseString("Srikanth"));

		System.out.println(ArrayReverse.getBinaryString(9));
		System.out.println(Integer.toBinaryString(9));
	}
}
