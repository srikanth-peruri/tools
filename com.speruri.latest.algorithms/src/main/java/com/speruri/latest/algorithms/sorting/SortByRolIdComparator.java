package com.speruri.latest.algorithms.sorting;

import java.util.Comparator;

public class SortByRolIdComparator implements Comparator<Student> {

	public int compare(Student s1, Student s2) {
		return s1.getRollNumber() - s2.getRollNumber();
	}

}
