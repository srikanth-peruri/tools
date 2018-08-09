package com.speruri.latest.algorithms.bitmanipulation;

public class SwapBits {

	public static int swapEverything(int input) {
		// Get the even bits of x
		// The number 0xAAAAAAAA is a 32 bit number with all even bits set as 1
		// and all odd bits as 0.
		int evenBits = input & 0xAAAAAAAA;
		// The number 0x55555555 is a 32 bit number with all odd bits set as 1
		// and all even bits as 0.
		int oddBits = input & 0x55555555;

		// right shift the even bits
		evenBits >>= 1;
		// left shift the odd bits
		oddBits <<= 1;
		return (evenBits | oddBits);
	}

	public static boolean[] convertToBinary(int number) {
		boolean[] bytes = new boolean[32];
		int length = (bytes.length - 1);
		int count = 0;
		while (number >= 0 && count <= length) {
			bytes[length - count] = (number % 2 == 1 ? true : false);
			number = number >> 1;
			count++;
		}
		return bytes;
	}

	static boolean checkSame(int n) {
		int set = 0;
		int unset = 0;
		int count = 0;
		// iterate for all
		// bits of a number
		while (n == 0) {

			// if set
			if (n > 1)
				set++;

			// if unset
			else
				unset++;

			// right shift
			// number by 1
			n = n >> 1;
			count++;
		}

		// is number of set bits
		// are equal to unset bits
		if (set == unset)
			return true;
		else
			return false;
	}

	static boolean isHavingDifferentSigns(int x, int y) {
		return ((x ^ y) < 0);
	}

	static int addOne(int input) {
		return (-(~input));
	}

	static int multiplywith35(int x) {
		return (x << 1) + x + (x >> 1);
	}

	static String findBinaryNumberWithrecursion(int x, String bin) {
		if (x <= 0) {
			return bin;
		}

		bin = (x % 2) + bin;
		return findBinaryNumberWithrecursion(x / 2, bin);
	}

	public static void main(String[] args) {
		System.out.println("Binary format :");
		boolean[] binArray = SwapBits.convertToBinary(-(~(2)));
		for (boolean i : binArray) {
			System.out.print((i == false ? 0 : 1));
		}

		System.out.println();
		// System.out.println(SwapBits.swapEverything(42));

		System.out.println(59 & 0xAAAAAAAA);
		System.out.println(59 & 0x55555555);

		int num = 4;
		System.out.println(5 << num);
		System.out.println(5 >> num);

		System.out.println(checkSame(12));

		System.out.println(isHavingDifferentSigns(-100, 100));

		System.out.println(addOne(120));

		System.out.println((~(2) + 1));
		// 0010 -> 1101 --> 1101 + 0001 -->
		// -2 = ~2 + 1
		// -x = ~x + 1;
		// -(~x) = ~(~x) + 1;
		// -(~x) = x +1;
		System.out.println(~2 + 1);

		System.out.println(multiplywith35(3));
		System.out.println(findBinaryNumberWithrecursion(7, ""));
	}

}
