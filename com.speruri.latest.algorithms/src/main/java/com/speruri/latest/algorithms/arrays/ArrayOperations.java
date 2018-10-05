package com.speruri.latest.algorithms.arrays;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class ArrayOperations {

	// For rotating the array, we simply take 2 pointers.
	// low and high
	// simply access the first and last and then swap
	// O(n) complexity
	public static void rotateArray(int a[]) {
		if (a == null || a.length == 0) {
			return;
		}
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			CustomArrayUtils.swap(a, low, high);
			low++;
			high--;
		}
	}

	// For this we can first copy the d elements into the temp array
	// and then shift the elements to its left position and finally add the d
	// elements to the right of the aray
	// O(n*d)
	public static void rotateByNumber(int[] a, int d) {
		if (a == null || a.length == 0 || d <= 0) {
			return;
		}

		// copy into temp array
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = a[i];
		}

		// now shift the elements from right to left
		for (int i = 0; i < d; i++) {
			int l = 0;
			while (l < a.length - 1) {
				a[l] = a[l + 1];
				l++;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			a[a.length - d + i] = temp[i];
		}

	}

	// This is kadane's algorith to find the max sum of the continous sub array
	// O(n)
	public static int[] maxSumForContinousSubArrayUsingKadane(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		int maxSoFar = 0;
		int maxEnd = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < a.length; i++) {
			maxEnd += a[i];
			if (maxEnd < 0) {
				maxEnd = 0;
				s = i + 1;
			}
			if (maxSoFar < maxEnd) {
				maxSoFar = maxEnd;
				start = s;
				end = i;
			}
		}
		System.out.println("Found the indexes as :  start : " + start + " end : " + end);
		int[] temp = new int[end - start + 1];
		for (int i = start, j = 0; i <= end; i++, j++) {
			temp[j] = a[i];
		}
		return temp;
	}

	public static void rotateArray(int[] a, int d) {
		if (a == null || a.length == 0 || d < 0) {
			return;
		}

		int count = d;
		int t = 0;
		int i = 0;
		boolean done = false;
		int[] temp = new int[a.length];

		while (!done) {
			temp[i++] = a[count++ % a.length];
			t++;
			if (t == a.length) {
				done = true;
			}
		}

		for (int j = 0; j < temp.length; j++) {
			System.out.print(temp[j] + " ");
		}

	}

	private static Stack<Integer> stack = new Stack<Integer>();
	private static int maxElement = Integer.MIN_VALUE;

	public static void handleOperation(String operation) {
		if (operation == null || operation.isEmpty()) {
			return;
		}

		String[] operations = operation.split(" ");
		if (operations != null) {

			int op1 = Integer.valueOf(operations[0]);
			int op2 = -1;
			if (operations.length > 1) {
				op2 = Integer.valueOf(operations[1]);
			}

			switch (op1) {
			case 1:
				stack.push(op2);
				if (op2 > maxElement) {
					maxElement = op2;
				}
				break;
			case 2:
				int e = stack.pop();
				if (e == maxElement) {
					maxElement = e;
				}
				break;
			case 3:
				System.out.println(maxElement);
				break;
			default:
				System.out.println("Enter valid operation");
				break;
			}
		}

	}

	public static int euclidGcd(int dividend, int divisor) {
		if (divisor == 0)
			return dividend;
		int remainder = dividend % divisor;
		return euclidGcd(divisor, remainder);
	}

	public static int findInSortedRotatedArray(int[] a, int k) {

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == k) {
				return mid;
			} else if (a[mid] <= a[high]) {
				if (k <= a[high] && k >= a[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (k >= a[low] && k <= a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	static int search(int arr[], int l, int h, int key) {
		if (l > h)
			return -1;

		int mid = (l + h) / 2;
		if (arr[mid] == key)
			return mid;

		/* If arr[l...mid] is sorted */
		if (arr[l] <= arr[mid]) {
			/*
			 * As this subarray is sorted, we can quickly check if key lies in
			 * half or other half
			 */
			if (key >= arr[l] && key <= arr[mid])
				return search(arr, l, mid - 1, key);

			return search(arr, mid + 1, h, key);
		}

		/*
		 * If arr[l..mid] is not sorted, then arr[mid... r] must be sorted
		 */
		if (key >= arr[mid] && key <= arr[h])
			return search(arr, mid + 1, h, key);

		return search(arr, l, mid - 1, key);
	}

	public static void main(String[] args) throws UnknownHostException {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		rotateArray(a);
		CustomArrayUtils.printArray(a);
		rotateArray(a);
		rotateByNumber(a, 2);
		System.out.println("Rotated array");
		CustomArrayUtils.printArray(a);
		int b[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Max sum is of continous sub array is ");
		CustomArrayUtils.printArray(maxSumForContinousSubArrayUsingKadane(b));
		int[] ra = { 1, 2, 3, 4, 5 };
		System.out.println("Rotation");
		rotateArray(ra, 4);
		System.out.println("GCD");

		System.out.println(euclidGcd(400, 124));

		System.out.println((int) 'a');

		System.out.println("Search");
		int[] arr = { 4, 5, 6, 7, 8, 1, 2, 3, };
		System.out.println(findInSortedRotatedArray(arr, 3));

		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(4);
		System.out.println("Before sort");
		System.out.println(list.toString());
		java.util.Collections.sort(list, Comparator.reverseOrder());
		// list.sort(new Comparator<Integer>() {
		// @Override
		// public int compare(Integer i1, Integer i2) {
		// if (i1 == i2) {
		// return 0;
		// } else if (i1 < i2) {
		// return -1;
		// } else if (i2 < i1) {
		// return 1;
		// }
		// return -1;
		// }
		// });
		System.out.println(list.toString());
		//

		InetAddress inetAddress = InetAddress.getByName("192.128.1.3");
		byte[] addr = inetAddress.getAddress();
		for (int j = 0; j < addr.length; j++) {
			System.out.print(addr[j] + " ");
			System.out.print((addr[j] & 255) + " ");
		}

		InetAddress iAddress2 = InetAddress.getByName("192.128.1.5");
		InetAddress iAddress1 = InetAddress.getByName("192.128.1.3");
		InetAddress iAddress3 = InetAddress.getByName("10.128.1.3");
		InetAddress iAddress4 = InetAddress.getByName("10.10.10.10");
		InetAddress iAddress5 = InetAddress.getByName("168.128.1.1");
		List<InetAddress> ipList = new ArrayList();
		ipList.add(iAddress1);
		ipList.add(iAddress2);
		ipList.add(iAddress3);
		ipList.add(iAddress4);

		List<String> ipStrList = new ArrayList();
		ipStrList.add("192.128.1.5");
		ipStrList.add("192.128.1.25");
		ipStrList.add("10.10.10.10");
		ipStrList.add("168.128.1.1");
		ipStrList.add("10.128.1.3");

		Comparator<InetAddress> comp = new Comparator<InetAddress>() {
			@Override
			public int compare(InetAddress ip1, InetAddress ip2) {
				byte[] b1 = ip1.getAddress();
				byte[] b2 = ip2.getAddress();
				if (b1.length < b2.length) {
					return -1;
				}
				if (b1.length < b2.length) {
					return 1;
				}
				for (int j = 0; j < addr.length; j++) {
					int i1 = b1[j] & 255;
					int i2 = b2[j] & 255;
					System.out.print(i1 + " ");
					System.out.print(i2 + " ");
					if (i1 < i2) {
						return -1;
					}
					if (i1 > i2) {
						return 1;
					}
				}
				return 0;
			}
		};

		Comparator<String> strComp = new Comparator<String>() {
			@Override
			public int compare(String ip1, String ip2) {
				String[] ip1Split = org.apache.commons.lang.StringUtils.split(ip1, ".");
				String[] ip2Split = org.apache.commons.lang.StringUtils.split(ip2, ".");
				if (ip1Split.length < ip2Split.length) {
					return -1;
				}
				if (ip1Split.length > ip2Split.length) {
					return 1;
				}

				int[] b1 = new int[ip1Split.length];
				int[] b2 = new int[ip2Split.length];

				for (int j = 0; j < b1.length; j++) {
					b1[j] = Integer.valueOf(ip1Split[j]);
					b2[j] = Integer.valueOf(ip2Split[j]);
				}

				for (int j = 0; j < b1.length; j++) {
					int i1 = b1[j] & 255;
					int i2 = b2[j] & 255;
					if (i1 < i2) {
						return -1;
					}
					if (i1 > i2) {
						return 1;
					}
				}
				return 0;
			}
		};

		ipStrList.sort(strComp);
		System.out.println("After sorting");
		for (String iadd : ipStrList) {
			System.out.println(iadd);
		}
		int i = 129;
		short k = (short) 32_768;
		int j = k;
		byte by = (byte) i;
		System.out.println("raw byte is " + (by & 255));
		System.out.println(Byte.toUnsignedInt(by));
		System.out.println("raw short is " + (j));

		System.out.println(5430 % 100);
		System.out.println(30 % 50);
		System.out.println(30 % 20);
		System.out.println(20 % 10);
		System.out.println(5430 / 100);

		outerloop: for (int out = 0; out < 10; out++) {
			for (int in = 0; in < 10; in++) {
				System.out.println(out + " - > " + in);
				if (in == 5) {
					break outerloop;
				}
			}
		}
		System.out.println(1.0 / 0.0);

		double d = 0.1;
		double sd = 3; 
		double x = d * sd;
		System.out.println(x);

	}

	public String getMethod() {
		return "From super class";
	}

}
