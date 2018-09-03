package com.speruri.latest.algorithms.sorting;

//interface
import java.util.Arrays;
import java.util.Collections;

//Driver class
class SortByComparator {
	public static void main(String[] args) {
		Student[] arr = { new Student(111, "bbbb", "london"), new Student(131, "aaaa", "nyc"),
				new Student(121, "cccc", "jaipur") };

		System.out.println("Unsorted");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

//		Arrays.sort(arr);
		Collections.sort(Arrays.asList(arr));

		System.out.println("\nSorted by rollno");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
}
