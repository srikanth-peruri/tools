package com.speruri.latest.algorithms.stacks;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TwoStacks {

	/*
	 * Complete the twoStacks function below.
	 */
	static int twoStacks(int x, int[] a, int[] b) {
		/*
		 * Write your code here.
		 */

		if (x == 0 || a == null || b == null || a.length == 0 || b.length == 0) {
			return 0;
		}

		Stack<Integer> aStack = new Stack<Integer>();
		Stack<Integer> bStack = new Stack<Integer>();
		int counter = 0;
		int maxSum = x;
		int sum = 0;

		for (int i = a.length - 1; i >= 0; i--) {
			aStack.push(a[i]);
		}
		for (int i = b.length - 1; i >= 0; i--) {
			bStack.push(b[i]);
		}

		int count = 0;

		while (sum < maxSum && (count <= a.length || count <= b.length)) {
			int aCurrent = (!aStack.isEmpty() ? aStack.peek() : 0);
			int bCurrent = (!bStack.isEmpty() ? bStack.peek() : 0);

			if (!aStack.isEmpty() && (sum + aCurrent) <= maxSum) {
				sum = (sum + aCurrent);
				aStack.pop();
				counter++;
			}
			if (!bStack.isEmpty() && (sum + bCurrent) <= maxSum) {
				sum = (sum + bCurrent);
				bStack.pop();
				counter++;
			}
			count++;
		}

		return counter;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int g = Integer.parseInt(scanner.nextLine().trim());

		for (int gItr = 0; gItr < g; gItr++) {
			String[] nmx = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmx[0].trim());

			int m = Integer.parseInt(nmx[1].trim());

			int x = Integer.parseInt(nmx[2].trim());

			int[] a = new int[n];

			String[] aItems = scanner.nextLine().split(" ");

			for (int aItr = 0; aItr < n; aItr++) {
				int aItem = Integer.parseInt(aItems[aItr].trim());
				a[aItr] = aItem;
			}

			int[] b = new int[m];

			String[] bItems = scanner.nextLine().split(" ");

			for (int bItr = 0; bItr < m; bItr++) {
				int bItem = Integer.parseInt(bItems[bItr].trim());
				b[bItr] = bItem;
			}

			int result = twoStacks(x, a, b);
			System.out.println("Result is " + result);
		}

	}
}
