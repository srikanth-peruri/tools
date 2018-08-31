package com.speruri.latest.algorithms.strings;

import com.speruri.latest.algorithms.bitmanipulation.CountBitsets;

public class CheckMinimumLengthToMakeAnagram {

	public static int minimumCharsToRemoveToMakeAnagram(String s1, String s2) {
		int count = 0;
		if (s1 == null && s2 == null) {
			return 0;
		}

		// take an array of 256 size and then iterate on the smallest string and
		// then add the char at that position and subtract at the char position

		int[] sw = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			sw[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			sw[s2.charAt(i)]--;
		}

		for (int i = 0; i < 256; i++) {
			if (sw[i] == 1) {
				count += Math.abs(sw[i]);
			}
		}

		return count;
	}

	public static boolean isKAnagrams(String s1, String s2, int k) {
		if (s1 == null || s2 == null || (s1.length() != s2.length())) {
			return false;
		}

		int[] sw = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			sw[s1.charAt(i) - 'a']++;
		}
		int count = 0;

		for (int i = 0; i < s2.length(); i++) {
			if (sw[s2.charAt(i) - 'a'] > 0) {
				sw[s2.charAt(i) - 'a']--;
			} else {
				count++;
			}
			if (count > k) {
				return false;
			}
		}

		for (int i = 0; i < sw.length; i++) {
			if (sw[i] != 0) {
				count += Math.abs(sw[i]);
			}
		}
		System.out.println(count);
		return true;
	}

	public static void main(String[] args) {
		String str1 = "cddgk", str2 = "gcd";
		System.out.println(minimumCharsToRemoveToMakeAnagram(str1, str2));

		str1 = "anagram";
		str2 = "grammar";
		int k = 3;
		System.out.println(isKAnagrams(str1, str2, k));
	}
}
