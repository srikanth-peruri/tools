package com.speruri.latest.algorithms.arrays.operations;

public class IpOperations {

	public static void generateIpUtil(String input, String output, int countDot, int val) {
		if (input.length() == 0) {
			if (countDot == 3 && !output.endsWith("."))
				System.out.println(output);
		} else {
			char firstChar = input.charAt(0);
			output += firstChar;
			int numValue = Character.digit(firstChar, 10);
			val = val * 10 + numValue;

			if (val <= 255) {
				if (countDot < 3) {
					generateIpUtil(input.substring(1), output + ".", countDot + 1, 0);
				}
				generateIpUtil(input.substring(1), output, countDot, val);
			}
		}
	}

	public static void main(String[] args) {
		IpOperations ipQuestion = new IpOperations();
		ipQuestion.generateIpUtil("10101010", "", 0, 0);
	}
}
