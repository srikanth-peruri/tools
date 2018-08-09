package com.speruri.latest.algorithms.recursion;

public class Fibonacci {
	static int fibonacci(int number, String caller) {
		System.out.println(caller + "->" + number);
		if (number <= 1) {
			return number;
		}
		return fibonacci(number - 1, "Call from 1") + fibonacci(number - 2, "Call from 2");
	}

	public static void main(String[] args) {
		System.out.println(Fibonacci.fibonacci(4, "Call from main"));
	}
}
