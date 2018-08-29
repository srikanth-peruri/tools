package com.speruri.latest.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {
	public static boolean areAnagrams(String str1, String str2) {
		if (str1 == null || str2 == null || (str1.length() != str2.length())) {
			return false;
		}

		// If we need to ignore case?
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		int[] a = new int[256];

		for (int i = 0; i < str1.length(); i++) {
			a[str1.charAt(i)]++;
			a[str2.charAt(i)]--;
		}

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("Is anagram : " + areAnagrams("geeksforgeeks", "forgeeksgeeks"));
	}
}
