package com.speruri.latest.algorithms.arrays;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class ArrayRotations {

	public static void rotateArrayinoofn(int[] a, int k) {
		if (a == null || a.length == 0 || k > a.length) {
			return;
		}

		int length = a.length;
		int i = 0;
		while (i < length) {
			int newIndex = (i - (k % length) + length) % k;
			CustomArrayUtils.swap(a, newIndex, i);
			i++;
		}

		java.util.Arrays.stream(a).forEach(System.out::print);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArrayinoofn(array, 2);
	}

}
