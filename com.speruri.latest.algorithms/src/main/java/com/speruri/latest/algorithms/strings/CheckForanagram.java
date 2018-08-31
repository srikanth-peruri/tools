package com.speruri.latest.algorithms.strings;

public class CheckForanagram {

	public static boolean areAnagram(String s1, String s2) {
		if (s1 == null || s2 == null || (s1.length() != s2.length())) {
			return false;
		}

		int[] s1w = new int[256];

		// Iterate on both the strings and then update the arrays with the
		// matched char
		for (int i = 0; i < s1.length(); i++) {
			s1w[s1.charAt(i)]++;
			s1w[s2.charAt(i)]--;
		}

		for (int i = 0; i < s1w.length; i++) {
			if (s1w[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("Are anagrams : " + areAnagram("aca", "aca"));
	}
}
