package com.speruri.latest.algorithms.stacks;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import org.apache.commons.lang.StringUtils;

public class PostFixOperationWithStack {

	private static Map<String, Integer> operatorsMap;

	static {
		operatorsMap = new HashMap<>();
		operatorsMap.put("(", 1);
		operatorsMap.put("{", 2);
		operatorsMap.put("[", 3);
		operatorsMap.put("/", 4);
		operatorsMap.put("*", 5);
		operatorsMap.put("+", 6);
		operatorsMap.put("-", 7);
		Comparator<Integer> operatorComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer prec1, Integer prec2) {
				return (prec1 < prec2 ? -1 : 0);
			}
		};
		PriorityQueue<Integer> p = new PriorityQueue<>(operatorsMap.size(), operatorComparator);
	}

	public static int evaluatePostfix(String expr) {
		if (expr == null || expr.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		String[] chars = StringUtils.split(expr, " ");

		for (String operand : chars) {
			if (operand == " ") {
				continue;
			}
			if (operatorsMap.get(operand) != null) {
				int result = performOperation(stack, operand + "");
				stack.push(result);
			} else {
				stack.push(atoi(operand));
			}
		}
		return stack.peek();
	}

	public static int evaluatePrefixOperation(String expr) {
		if (expr == null || expr.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		String operator = null;

		String[] chars = StringUtils.split(expr, " ");

		for (int i = chars.length - 1; i >= 0; i--) {
			String s = chars[i];
			if (s == " ") {
				continue;
			}

			if (operatorsMap.get(s) != null) {
				operator = s;
				stack.push(performOperation(stack, operator));
			} else {
				stack.push(atoi(s));
			}

		}

		return stack.peek();
	}

	private static int performOperation(Stack<Integer> stack, String operand) {
		int op1 = stack.pop();
		int op2 = stack.pop();
		int result = 0;
		switch (operand) {
		case "+":
			result = op1 + op2;
			break;
		case "-":
			result = op1 - op2;
			break;
		case "*":
			result = op1 * op2;
			break;
		case "/":
			result = op1 / op2;
			break;
		case "%":
			result = op1 % op2;
			break;
		}
		return result;
	}

	public static int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		// 1000
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			result += (c - '0') * Math.pow(10, (str.length() - 1 - i));
		}
		return result;
	}

	public static void main(String[] args) {
		String expr = "2 3 +";
		String prefixExpr = "- + * 2 3 * 5 4 9";
		System.out.println("Postfix Result is :" + PostFixOperationWithStack.evaluatePostfix(expr));
		System.out.println("Prefix Result is :" + PostFixOperationWithStack.evaluatePrefixOperation(prefixExpr));
		System.out.println(atoi("1001"));

	}
}
