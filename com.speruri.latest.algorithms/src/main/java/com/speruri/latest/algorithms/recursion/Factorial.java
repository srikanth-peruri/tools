package com.speruri.latest.algorithms.recursion;

public class Factorial {

	static int doublefactorial(int number) {
		if (number > 0) {
			int smaller = number - 1;
			int greater = number + 1;
			return factorial(smaller) + factorial(number) + factorial(greater);
		}
		return 0;
	}

	static int factorial(int number) {
		// Base case
		if (number <= 1) {
			return 1;
		}
		// recursive Case
		return number * factorial(number - 1);
	}

	public static void main(String[] args) {
		System.out.println(Factorial.doublefactorial(7));
	}

}
