package com.speruri.latest.algorithms.bitmanipulation;

public class ParityChecker {

	enum PARITY {
		EVEN, ODD, NONE
	}

	public static PARITY getParityOfNumber(int number) {
		PARITY parity = PARITY.NONE;
		int count = getParityCount(number);
		if (count % 2 == 0) {
			parity = PARITY.EVEN;
		} else if (count % 2 == 1) {
			parity = PARITY.ODD;
		}
		System.out.println();
		return parity;
	}

	private static int getParityCount(int argNumber) {
		if (argNumber <= 0) {
			return 0;
		}
		int rem = (argNumber % 2 == 0 ? 0 : 1);
		System.out.print(rem);
		return rem + getParityCount(argNumber / 2);
	}

	public static void main(String[] args) {
		System.out.println(getParityOfNumber(254));
	}

}
