package com.speruri.latest.algorithms.strings;

public class SubStringsWithAnagram {

	public static boolean compare(int[] a, int[] b) {
		for (int i = 0; i < 256; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void printAnagrams(String searchString, String text) {
		if (searchString == null || text == null) {
			return;
		}
		int textLength = text.length();
		int strLength = searchString.length();

		int[] twArray = new int[256];
		int[] ssArray = new int[256];

		for (int i = 0; i < strLength; i++) {
			twArray[text.charAt(i)]++;
			ssArray[searchString.charAt(i)]++;
		}

		for (int i = strLength; i < textLength; i++) {
			if (compare(twArray, ssArray)) {
				System.out.println("Panagram found at index : " + (i - strLength));
			}

			// slide the window
			twArray[text.charAt(i)]++;
			// Since the anagram found at (i - strLength) we should decrement
			// the count
			twArray[text.charAt(i - strLength)]--;

		}

		if (compare(twArray, ssArray)) {
			System.out.println("Panagram found at index : " + (textLength - strLength));
		}
	}

	public static void main(String args[]) {
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		printAnagrams(pat, txt);
	}
}
