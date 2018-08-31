package com.speruri.latest.algorithms.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//Given an array, find the pairs of numbers with a sum
public class ArrayOperations {

	// We can solve this in 2 ways
	// 1. Naive method. Put two loops and then calculate the sum and check
	// whether its equal or not. This takes O(n^2)
	// 2. Using the sorting, we can sort the array and then find the sum which
	// would take O(nlogn)
	// 3. Using a hashmap, we can insert the values into hashmap. then while
	// iterating the array, we can see the difference of sum and current element
	// and then check the difference element in the hashmap. If found log it.
	// lookup in hashmap takes O(1). And since we are iterating the array once.
	// It takes
	// O(n).. This is better solution

	// Questions to ask
	// Will this contains sorted elements or not
	// will this contain negative or not

	static void printSumOfelementsUsingSorting(int[] a, int sum) {
		if (a == null || a.length == 0) {
			return;
		}

		Arrays.sort(a);

		int low = 0;
		int high = a.length - 1;

		while (low < high) {
			int currentSum = a[low] + a[high];
			if (currentSum == sum) {
				System.out.format("Found pair at index %d and %d with values (%d and %d)", low, high, a[low], a[high]);
				System.out.println();
			}
			// Since f is smaller and l is bigger
			if (a[low] + a[high] < sum) {
				low++;
			} else {
				high--;
			}
		}
	}

	static void printSumOfelements(int[] a, int sum) {
		if (a == null || a.length == 0) {
			return;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			int current = a[i];
			int diff = sum - current;

			if (map.containsKey(diff)) {
				System.out.format("Found pair at index %d and %d with values (%d and %d)", i, map.get(diff), current,
						diff);
				System.out.println();
			}
			map.put(current, i);
		}

	}

	// Given a binary array with elements 0's,1's, we need to sort them
	// Here is the first solution to iterate each element and check whether its
	// 0 or not.
	// If 0, then fill the adjacent element j with 0;
	// Continue this until we reach the end of the array.
	// Then fill all the other elements from j to end with 1's
	// It takes O(n)
	public static void sortBinaryArray(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int j = 0;

		// Iterate till the end of the array and update the array with 0's
		// and increment the jth index
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				a[j++] = 0;
			}
		}

		for (int i = j; i < a.length; i++) {
			a[i] = 1;
		}

	}

	// Given a binary array, we need to sort the array with all 0's at first
	// followed by all 1's
	// We can use the partivion logic of Quick sort and then sort the values by
	// taking the pivot as 1
	// take an index j which only increments when the current element is less
	// than pivot.
	public static void sortBinaryarrayWithQuickSortPartition(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int j = 0;
		int pivot = 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < pivot) {
				swap(a, i, j);
				j++;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Finding dulicate number in the array
	// To find the duplicate number in an array, we can simply use the hash map
	// with key as number and value as no of occurences
	// This way finally we can iterate on the map and then see what the no of
	// occurences of an int
	// Time complexity is O(n), space complexity is O(n)
	public static void findDuplicateInArrayWithHashMap(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			counter.put(a[i], counter.getOrDefault(a[i], 0) + 1);
		}

		System.out.println("Duplicates found is : ");
		for (Entry<Integer, Integer> entry : counter.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print(entry.getKey() + " ");
			}
		}

	}

	// If we know that the array elements are positive and lesser than the 256
	// then we can put an array and then populate the items of first array to
	// new array and then increment the count
	// of each element
	public static void findDuplicateInArrayWithAnotherArray(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int[] counter = new int[256];
		for (int i = 0; i < a.length; i++) {
			counter[a[i]]++;
		}

		for (int i = 0; i < 256; i++) {
			if (counter[i] > 1) {
				System.out.print(i + " ");
			}
		}

	}

	public static void findDuplicateInArrayWithXOR(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int xor = 0;

		for (int i = 0; i < a.length; i++) {
			xor ^= a[i];
		}

		for (int i = 0; i < a.length; i++) {
			xor ^= i;
		}

		System.out.println("\nMissing number is : " + xor);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 8, 7, 2, 5, 3, 1 };
		System.out.println("With sorting");
		printSumOfelementsUsingSorting(a, 10);
		System.out.println("With hashmap");
		int[] b = new int[] { 8, 7, 2, 5, 3, 1 };
		printSumOfelements(b, 10);
		System.out.println("Sort binary array ");
		int[] ba = new int[] { 1, 0, 1, 0, 1, 0, 0, 1 };
		sortBinaryArray(ba);
		for (int i = 0; i < ba.length; i++) {
			System.out.print(ba[i] + " ");
		}
		System.out.println();
		System.out.println("Partition logic oof quick sort");
		ba = new int[] { 1, 0, 1, 0, 1, 0, 0, 1 };
		sortBinaryArray(ba);
		for (int i = 0; i < ba.length; i++) {
			System.out.print(ba[i] + " ");
		}

		System.out.println("Duplicates ");
		b = new int[] { 8, 7, 2, 2, 1, 5, 3, 1, 3 };
		findDuplicateInArrayWithHashMap(b);
		b = new int[] { 8, 7, 2, 2, 1, 5, 3, 1, 3 };
		System.out.println();
		findDuplicateInArrayWithAnotherArray(b);

		
		a = new int[] { 1, 2, 3, 4, 4 };
		findDuplicateInArrayWithXOR(a);

	}

}
