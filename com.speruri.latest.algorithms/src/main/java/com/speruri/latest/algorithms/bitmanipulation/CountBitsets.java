package com.speruri.latest.algorithms.bitmanipulation;

public class CountBitsets {

	public static int countAllBitSets(int number) {
		int count = 0;
		for (int i = 0; i < number; i++) {
			count += countBitSetsOfaNumber(i);
		}
		return count;
	}

	public static int countBitSetsOfaNumber(int number) {
		// Base case
		if (number <= 0) {
			return 0;
		}
		// Recursive case
		return (number % 2 == 0 ? 0 : 1) + countAllBitSets(number);
	}

	public static void main(String[] args) {
		System.out.println(CountBitsets.countAllBitSets(4));
	}
}
