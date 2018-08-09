package com.speruri.latest.algorithms.binarysearch;

public class BinarySearch {

	public int binarySearch(int[] list, int itemToFind) {

		int first = 0;
		int last = list.length - 1;

		while (first <= last) {
			int mid = (first + last) / 2;
			int midItem = list[mid];

			if (midItem == itemToFind) {
				return mid;
			} else if (itemToFind > midItem) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		// int[] list = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
		// };
		int[] list = { 1, 3, 5, 7, 9 };
		int itemToFind = 3;
		int itemFoundAt = binarySearch.binarySearch(list, itemToFind);
		System.out.println("Item Found at : " + itemFoundAt);

	}
}
