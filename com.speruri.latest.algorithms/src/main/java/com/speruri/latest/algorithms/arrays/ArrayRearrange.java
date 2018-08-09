package com.speruri.latest.algorithms.arrays;

import java.util.Arrays;

public class ArrayRearrange {

	static void rearrangearray(int[] a) {
		// a={7,6,5,4,3,2,1}
		// calculate the even positions
		int evenPos = a.length;
		// Calculate the odd positions
		int oddPos = a.length - evenPos;

		int[] tempArray = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			tempArray[i] = a[i];
		}

		// Sort the array now
		Arrays.sort(tempArray);
		// tempArray = {1,2,3,4,5,6,7}

		// now update the even positions with the decrementing odd position
		// since a[i] >= a[j]

		int j = oddPos - 1;
		for (int i = 0; i < a.length; i += 2) {
			a[i] = tempArray[j];
			j--;
		}
		// a = {4,6,3,4,2,2,1}
		j = oddPos;

		for (int i = 0; i < a.length; i += 2) {
			a[i] = tempArray[j];
			j++;
		}
		System.out.println("Arrays rearranged is");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public static void main(String[] args) {
		int a[] = { 7, 6, 5, 4, 3, 2, 1 };
		rearrangearray(a);
	}
}
