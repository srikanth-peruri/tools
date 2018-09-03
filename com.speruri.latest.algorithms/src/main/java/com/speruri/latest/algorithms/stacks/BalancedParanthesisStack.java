package com.speruri.latest.algorithms.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesisStack {

	private static Map<Character, Character> map;

	public BalancedParanthesisStack() {
		map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
	}

	private boolean isBalancedParanthesis(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		Stack<Character> charStack = new Stack<Character>();
		// {[()]}
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			Character openingChar = map.get(currentChar);
			if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
				charStack.push(currentChar);
			} else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
				if (charStack.isEmpty() || (openingChar != null && openingChar != charStack.pop())) {
					return false;
				}
			}
		}

		return charStack.isEmpty();
	}

	public static void main(String[] args) {
		BalancedParanthesisStack b = new BalancedParanthesisStack();
		System.out.println(b.isBalancedParanthesis("{[([a+b-c]])]}"));
	}
}
