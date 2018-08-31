package com.speruri.latest.algorithms.arrays;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class PrimeNumbers {

	static java.util.List<Integer> primeNumberInRange(int n) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		if (n >= 2) {
			primeNumbers.add(2);
		}
		for (int i = 3; i <= n; i += 2) {
			if (isPrimeBruteForce(i)) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}

	private static boolean isPrimeBruteForce(int number) {
		for (int i = 2; i * i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		java.util.List<Integer> a = primeNumberInRange(9);
		for (int i = 0; i < a.size(); i++) {
			System.out.print(i + " ");
		}
	}
}
