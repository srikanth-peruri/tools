package com.speruri.latest.algorithms.strings;

public class StringPalindrome {
	static boolean isStringPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		int f = 0;
		int l = str.length() - 1;

		while (f < l) {
			char fc = str.charAt(f);
			char lc = str.charAt(l);
			if (fc != lc) {
				return false;
			}
			f++;
			l--;
		}
		return true;
	}

	static boolean isIntegerPalindrome(int number) {

		int palindrome = number;
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = (reverse * 10) + remainder;
			palindrome = palindrome / 10;
		}
		return reverse == number;
	}

	static int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		int s = 0;
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			s = (int) (s + ((c - 48) * Math.pow(10, (str.length() - 1 - i))));
		}

		return s;
	}

	static boolean isArmstrongNumber(int number) {
		int armstrong = number;
		int sum = 0;

		while (armstrong != 0) {
			int remainder = armstrong % 10;
			sum += Math.pow(remainder, 3);
			armstrong = armstrong / 10;
		}

		return sum == number;
	}

	public static void main(String[] args) {
		System.out.println("Is palindrome string : " + isStringPalindrome("bob"));
		System.out.println("Is integer Palindrome : " + isIntegerPalindrome(1001));
		System.out.println("Is integer Palindrome : " + atoi("1234"));
		System.out.println("Is integer Palindrome : " + isArmstrongNumber(153));
	}
}
