package com.speruri.latest.algorithms.sorting;

public class Bubblesort {

	public static int[] performBubblesort(int[] a) {
		if (a == null || a.length == 0) {
			return a;
		}

		// Since we need to swap the current element with next element, we just
		// traverse till len-1
		// Since we are bubbling the larger element to the end, we have to
		// reduce the last index
		// Since a[j] needs to be sent right, we have to check the for current
		// greater than next

		for (int i = 0; i < a.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[j + 1]) {
					swapped = true;
					CustomArrayUtils.swap(a, j, j + 1);
				}
			}
			if (!swapped) {
				break;
			}
		}

		return a;
	}

	public static void bubbleSortWithRecursion(int[] a, int n) {

		// Check whether the n == 0, then return
		if (n == 1) {
			return;
		}

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				CustomArrayUtils.swap(a, i, i + 1);
			}
		}
		bubbleSortWithRecursion(a, n - 1);
	}

	public static void main(String[] args) {
		int[] a = Bubblesort.performBubblesort(new int[] { 64, 34, 25, 12, 22, 11, 90 });
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println("Bubble sort with recursion");

		a = new int[] { 64, 34, 25, 12, 22, 11, 90 };
		Bubblesort.bubbleSortWithRecursion(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}

	}
}
