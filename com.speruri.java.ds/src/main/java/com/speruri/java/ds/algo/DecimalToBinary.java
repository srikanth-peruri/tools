package com.speruri.java.ds.algo;

public class DecimalToBinary {
	public static void main(String[] args) {
		int num = 4;

		String bin = "";

		while (num > 0) {
			bin = num % 2 + bin;
			num = num / 2;
		}
		for (int i = bin.length() - 1; i >= 0; i--) {
			System.out.print(bin.charAt(i));
		}
	}
}
