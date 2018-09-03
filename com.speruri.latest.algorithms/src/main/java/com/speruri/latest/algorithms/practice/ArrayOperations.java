package com.speruri.latest.algorithms.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

//Given an array, find the pairs of numbers with a sum
public class ArrayOperations<T> {

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

	// O(n*d)
	static void rotateArrayByd(int[] a, int d) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 0; i < d; i++) {
			rotateArrayByOne(a);
		}

	}

	static void rotateArrayByOne(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int e = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[a.length - 1] = e;
	}

	// Implement the array reversal by dividing them into sub arrays
	// O(n) time complexity
	// O(1) space complexity

	public static void rotateByDOOfN(int[] a, int d) {
		if (a == null || a.length == 0) {
			return;
		}

		int n = a.length - 1;
		reverseArray(a, 0, d - 1);
		reverseArray(a, d, n);
		reverseArray(a, 0, n);

	}

	public static void reverseArray(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}

		int temp = 0;
		while (low < high) {
			temp = a[low];
			a[low] = a[high];
			a[high] = temp;
			low++;
			high--;
		}

	}

	// Split the array and rotate. This is same as the above rotation.
	// O(n)
	// O(1)
	public static void splitArrayByd(int[] a, int d) {
		if (a == null || a.length == 0 || d > a.length) {
			return;
		}

		reverseA(a, 0, d - 1);
		reverseA(a, d, a.length - 1);
		reverseA(a, 0, a.length - 1);

	}

	public static void reverseA(int[] a, int low, int high) {
		if (a == null || a.length == 0) {
			return;
		}

		int temp;
		while (low < high) {
			temp = a[low];
			a[low] = a[high];
			a[high] = temp;
			low++;
			high--;
		}

	}

	// Rotate the array by clockwise one.
	// O(n)
	public static void rotateArrayByOneClockwise(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int len = a.length - 1;
		int temp = a[len];

		for (int i = len; i > 0; i--) {
			a[i] = a[i - 1];
		}

		a[0] = temp;
	}

	// Search in a sorted and rotated array.
	// For this, we will search the element which is smaller than the previous
	// element.
	// This way we can confirm that the previous element to that will be the
	// highest last element in the sorted array.
	// Then we can perform binary search which would take the O(logn)

	public static int searchInRotatedsortedArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int d = -1;
		int low = Integer.MAX_VALUE;
		// Rotate the array till we see the lowest element
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				low = a[i];
			}
		}

		return -1;
	}

	public static void rearrangeArrayBasedOnIndexes(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			if (set.contains(i)) {
				a[i] = i;
			} else {
				a[i] = -1;
			}
		}

	}

	// Binary search with O(logn)
	public static int performBinarySearch(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;
		int mid;

		while (low < high) {
			mid = (low + high) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else if (x > a[mid]) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public void reverseAnything(T[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int low = 0;
		int high = a.length - 1;

		while (low < high) {
			T temp = a[low];
			a[low] = a[high];
			a[high] = temp;
			low++;
			high--;
		}
	}

	public static void moveAllZerosToEndOfArray(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0 && j < a.length) {
				CustomArrayUtils.swap(a, i, j);
				j++;
			}
		}

	}

	public static void randomShuffle(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		Random r = new Random();
		int j = 0;
		for (int i = a.length - 1; i > 0; i--) {
			j = r.nextInt(i);
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

	}

	public static void multiplywithPrevious(int a[]) {
		if (a == null || a.length == 0) {
			return;
		}

	}

	public static void swapEvenOdd(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int j = 0;
		int temp;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}

	}

	public static void mergeSort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		int length = a.length;
		if (length < 2) {
			return;
		}

		int mid = length / 2;

		int[] left = new int[mid];
		int[] right = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int i = mid, j = 0; i < a.length; i++, j++) {
			right[j] = a[i];
		}

		mergeSort(left);
		mergeSort(right);
		mergeArraysBySorting(left, right, a);

	}

	private static void mergeArraysBySorting(int[] left, int[] right, int[] a) {
		int leftLength = left.length;
		int rightLength = right.length;

		int leftIndex = 0;
		int rightIndex = 0;
		int actualIndex = 0;

		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (left[leftIndex] < right[rightIndex]) {
				a[actualIndex] = left[leftIndex];
				leftIndex++;
			} else {
				a[actualIndex] = right[rightIndex];
				rightIndex++;
			}
			actualIndex++;
		}

		while (leftIndex < leftLength) {
			a[actualIndex] = left[leftIndex];
			leftIndex++;
			actualIndex++;
		}

		while (rightIndex < rightLength) {
			a[actualIndex] = right[rightIndex];
			rightIndex++;
			actualIndex++;
		}

	}

	public static int findkthelementInUnsortedArray(int[] a, int k) {
		int index = -1;
		if (a == null || a.length == 0 || k - 1 < 0) {
			return index;
		}
		mergeSort(a); // O(nlogn)
		return a[k - 1];
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
		System.out.println();
		System.out.println("rorate by d elements");

		a = new int[] { 1, 2, 3, 4, 5 };
		rotateArrayByd(a, 2);
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		a = new int[] { 1, 2, 3, 4, 5 };
		rotateByDOOfN(a, 2);
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		a = new int[] { 3, 1, 2 };
		splitArrayByd(a, 1);
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		a = new int[] { 2, 3, 1 };
		rotateArrayByOneClockwise(a);
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
		a = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Item foudn at : " + performBinarySearch(a, 4));

		int A[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		rearrangeArrayBasedOnIndexes(A);
		System.out.println();
		CustomArrayUtils.printArray(A);
		System.out.println();
		System.out.println("Integer reverse ");

		ArrayOperations<Integer> aOperations = new ArrayOperations<Integer>();
		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		aOperations.reverseAnything(intArray);
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
		System.out.println("Move all 0's to end ");

		int arr[] = { 1, 2, 0, 0, 0, 3, 6 };
		moveAllZerosToEndOfArray(arr);
		CustomArrayUtils.printArray(arr);
		System.out.println();

		System.out.println();
		System.out.println("Random Shuffle");
		randomShuffle(arr);
		CustomArrayUtils.printArray(arr);
		System.out.println();

		System.out.println();
		System.out.println("Swap even Odd");
		int[] array = { 1, 9, 5, 3, 2, 6, 7, 11 };
		swapEvenOdd(array);
		CustomArrayUtils.printArray(array);

		System.out.println();

		System.out.println();
		System.out.println("Merge Sort");
		int[] ma = { 12, 11, 13, 5, 6, 7 };
		mergeSort(ma);
		CustomArrayUtils.printArray(ma);
		System.out.println();

		int arra[] = { 7, 10, 4, 3, 20, 15 };
		System.out.println();
		System.out.println("Find kth element");
		System.out.println(findkthelementInUnsortedArray(arra, 3));
		System.out.println();

	}

}
