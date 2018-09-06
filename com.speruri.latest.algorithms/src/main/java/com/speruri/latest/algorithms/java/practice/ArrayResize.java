package com.speruri.latest.algorithms.java.practice;

import java.util.Arrays;

public class ArrayResize {

	public static void main(String[] args) {
		int[] a = new int[5];
		System.out.println(a.length);
		a = Arrays.copyOf(a, a.length * 2);
		System.out.println(a.length);
	}

}
