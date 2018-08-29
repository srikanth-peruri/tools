package com.speruri.latest.algorithms.graphs;

public class Panagram {

	static boolean isPanagram(String str) {
		boolean panagram = false;
		if (str == null || str.isEmpty()) {
			return false;
		}

		boolean[] visited = new boolean[26];

		// Questions to ask
		// Whether this have digits or not
		// Can be equals ignore case
		// will it have repeated letters or not

		byte[] bytes = str.getBytes();

		for (int i = 0; i < bytes.length; i++) {
			int c = bytes[i];
			if ((c >= 65 && c <= 90)) {
				visited[c - 65] = true;
			} else if (c >= 97 && c <= 122) {
				visited[c - 97] = true;
			}
		}

		panagram = true;
		for (int j = 0; j < visited.length; j++) {
			if (!visited[j]) {
				System.out.print(" " + (char) (97 + j) + " ");
				panagram = false;
			}
		}

		return panagram;
	}

	static void isPanagrammaticLipoGram(String str) {
		boolean[] visited = new boolean[26];
		int counter = 0;

		// the ASCII value of A = 65 , Z = 90 and a is 97 and z is 122

		byte[] bytes = str.getBytes();

		for (int i = 0; i < bytes.length; i++) {
			int c = bytes[i];
			if (c >= 65 && c <= 90) {
				visited[c - 65] = true;
			} else if (c >= 97 && c <= 122) {
				visited[c - 97] = true;
			}
		}

		for (int j = 0; j < visited.length; j++) {
			if (!visited[j]) {
				// System.out.print(" " + (char) (97 + j) + " ");
				counter++;
			}
		}

		if (counter == 0) {
			System.out.println("Its Panagram");
		} else if (counter == 1) {
			System.out.println("Its Panagrammatic Lipogram");
		} else if (counter > 1) {
			System.out.println("Not panagram might be lipogram");
		}
	}

	static void isnumber(String str) {
		if (str == null || str.isEmpty()) {
			return;
		}

	}

	static public void removePunctuationmarks(String str) {
		if (str == null || str.isEmpty()) {
			return;
		}

		byte[] bytes = str.getBytes();
		byte[] newbytes = new byte[bytes.length];

		for (int i = 0, j = 0; i < bytes.length; i++) {
			int c = bytes[i];
			if (c == ' ') {
				newbytes[j] = (byte) c;
				j++;
			} else if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
				newbytes[j] = (byte) c;
				j++;
			}
		}

		System.out.println("New string created is : " + new String(newbytes));
	}

	public static int atoi(String str) {
		if (str == null || str.isEmpty()) {
			return -1;
		}
		int num = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int j = '0';
			num = (num * 10) + (c - 48);
		}

		return num;
	}

	public static int reverseWithatio(String str) {
		if (str == null || str.isEmpty()) {
			return -1;
		}
		System.out.println((int) '0' + " " + (int) '9');
		int sum = 0;
		int len = str.length() - 1;
		for (int i = len, j = len; i >= 0; i--, j--) {
			char c = str.charAt(i);
			sum += (c - 48) * Math.pow(10, j);
		}

		return sum;
	}

	public static void main(String[] args) {
		// System.out.println((int) 'A');// 65
		// System.out.println((int) 'Z');// 90
		// System.out.println((int) 'a');// 97
		// System.out.println((int) 'z');// 122
		String str = "The quick  fox jumps over the lazy dog";
		System.out.println("Is panagram : " + isPanagram(str));
		String str1 = "The quick brown fox jumped over the lazy dog";
		isPanagrammaticLipoGram(str1);
		System.out.println();
		removePunctuationmarks("Welcome ???@@##$ to#$% Geeks%$^for$%^&Geeks");
		System.out.println();
		isnumber("0123456");

		System.out.println(atoi("1234"));
		System.out.println(reverseWithatio("1234"));

	}
}
