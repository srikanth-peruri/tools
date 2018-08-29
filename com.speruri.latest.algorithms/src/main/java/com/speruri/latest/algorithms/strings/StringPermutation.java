package com.speruri.latest.algorithms.strings;

public class StringPermutation {

	static void permutate(String str, int l, int r) {
		if (l == r) {
			System.out.println(str);
		}

		for (int i = 1; i < r; i++) {
			str = swap(str, i + l, i);
		}

	}

	private static String swap(String str, int i, int j) {
		byte[] bytes = str.getBytes();
		byte temp = bytes[i];
		bytes[i] = bytes[j];
		bytes[j] = temp;
		return String.valueOf(bytes);
	}

	public static void main(String[] args) {

	}
}
