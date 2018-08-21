package com.speruri.spring.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Balanced {

	enum RESULT {
		YES, NO
	}

	private static Stack<Character> stack = new Stack<>();
	private static Map<Character, Character> map = new HashMap<>();

	static boolean isOpenSymbol(Character c) {

		for (Character key : map.keySet()) {
			if (key == c) {
				return true;
			}
		}
		return false;
	}

	static boolean isCloseSymbol(Character c) {
		for (Character key : map.values()) {
			if (key == c) {
				return true;
			}
		}
		return false;
	}

	static boolean isaPair(Character key, Character value) {
		return (value.equals(map.get(key)));
	}

	static String isBalanced(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		stack.clear();

		s = s.trim();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');

		for (int i = 0; i < s.length(); i++) {
			char currentchar = s.charAt(i);
			if (!stack.isEmpty() && isCloseSymbol(currentchar)) {
				Character peekChar = stack.peek();
				if (isaPair(peekChar, currentchar)) {
					stack.pop();
					continue;
				} else {
					break;
				}
			} else {
				stack.push(currentchar);
			}
		}

		if (stack.isEmpty()) {
			return RESULT.YES.toString();
		}

		return RESULT.NO.toString();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);
			System.out.println(result);
		}

		System.out.println(isBalanced("{{[[(())]]}}"));
		scanner.close();
	}
}
