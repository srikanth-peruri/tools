package com.speruri.latest.algorithms.arrays;

import org.omg.CORBA.portable.RemarshalException;

public class MathOperations {

	static int factorial(int n) {
		if (n < 2) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	static String reverseString(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		byte[] bytes = str.getBytes();

		int f = 0;
		int l = bytes.length - 1;

		while (f < l) {
			byte cf = bytes[f];

			bytes[f] = bytes[l];
			bytes[l] = cf;

			f++;
			l--;
		}

		return new String(bytes);
	}

	public static int[] removeDuplicates(int[] a) {
		if (a == null || a.length == 0) {
			return a;
		}

		int[] newArray = new int[a.length];
		int[] counter = new int[256];

		for (int i = 0; i < a.length; i++) {
			counter[a[i]]++;
		}

		for (int i = 0, j = 0; i < counter.length; i++) {
			if (counter[i] != 0) {
				newArray[j] = i;
				j++;
			}
		}

		return newArray;
	}

	public static int[] findMissingNumber(int[] a, int n) {
		if (a == null || a.length == 0 || n < a.length) {
			return a;
		}

		int[] newArray = new int[n];
		int[] counter = new int[n];

		for (int i = 0; i < a.length; i++) {
			counter[a[i]]++;
		}

		for (int i = 0, j = 0; i < counter.length; i++) {
			if (counter[i] == 0) {
				newArray[j] = i;
				j++;
			}
		}
		return newArray;
	}

	static int[] findDuplicate(int[] a) {
		if (a == null || a.length == 0) {
			return a;
		}

		int[] newArray = new int[a.length];
		int[] counter = new int[256];

		for (int i = 0; i < a.length; i++) {
			counter[a[i]]++;
		}

		for (int i = 0, j = 0; i < counter.length; i++) {
			if (counter[i] > 1) {
				newArray[j++] = i;
			}
		}

		return newArray;
	}

	static void printminAndMax(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}

			if (a[i] < min) {
				min = a[i];
			}
		}

		System.out.format("Max is %d and min is %d ", max, min);
	}

	// static void findPairsWithSum(int[] a, int k) {
	// if (a == null || a.length == 0 || n < 1) {
	// return;
	// }
	// }

	static void findAllAnagrams(String searchString, String pattern) {
		if (searchString == null || pattern == null || searchString.isEmpty() || pattern.isEmpty()) {
			return;
		}

		// assign the lengths of the search string and the pattern
		int searchStringLength = searchString.length();
		int patLength = pattern.length();

		// first initialize two arrays each with 256 length. Since we consider 8
		// bits
		int[] sw = new int[256];
		int[] pw = new int[256];

		// Iterating on all the chars, update the array which matches position
		// Every char in ASCII char can be represented with 8 bits i.e, 256
		// chars, so thats the reason why we initialized the arrays with 256
		// length
		// update the corresponding positions of the arrays with the chars found
		for (int i = 0; i < pattern.length(); i++) {
			sw[searchString.charAt(i)]++;
			pw[pattern.charAt(i)]++;
		}

		// Now use the window sliding method and check for the patterns
		for (int i = patLength; i < searchStringLength; i++) {

			// Now compare the arrays elements. If all the elements are equal,
			// then we can say that the pattern is found
			if (compare(sw, pw)) {
				System.out.println("Found at : " + (i - patLength));
			}
			// now update the next char position in our text array
			sw[searchString.charAt(i)]++;
			// And decrement the previous element position since we are sliding
			// the window
			sw[searchString.charAt(i - patLength)]--;
		}

		if (compare(sw, pw)) {
			System.out.println("Found at : " + (searchStringLength - patLength));
		}

	}

	private static boolean compare(int[] sw, int[] tw) {
		for (int i = 0; i < tw.length; i++) {
			if (sw[i] != tw[i]) {
				return false;
			}
		}
		return true;
	}

	public static int distinctPermutations(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		int result = 0;

		int[] counter = new int[256];
		for (int i = 0; i < str.length(); i++) {
			counter[str.charAt(i)]++;
		}

		int fact = 1;
        for (int i = 0; i < 256; i++)
            fact = fact * factorial(counter[i]);
      
        // finding factorial of size of string and
        // dividing it by factorial found after
        // multiplying
        return factorial(str.length()) / fact;

	}

	public static void main(String[] args) {
		System.out.println(factorial(5));
		System.out.println(reverseString("Srikanth"));

		int[] a = removeDuplicates(new int[] { 1, 2, 2, 3, 4, 5 });
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("Missing one is ");
		a = findMissingNumber(new int[] { 1, 3, 4, 5 }, 10);
		if (a != null && a.length != 0) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
		}

		System.out.println("Duplicate one is ");
		a = findDuplicate(new int[] { 1, 3, 3, 4, 4, 4, 5, 102, 102 });
		if (a != null && a.length != 0) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != 0) {
					System.out.print(a[i] + " ");
				}
			}
		}
		System.out.println();
		printminAndMax(new int[] { 1, 3, 3, 4, 4, 4, 5, 102, 102 });
		System.out.println("Anagrams found at :");
		findAllAnagrams("ACBBCAFGHBCA", "ABC");
		System.out.println(distinctPermutations("ybghjhbuytb"));
	}
}
