package com.speruri.latest.algorithms.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static class Worker implements Runnable {

		private CountDownLatch latch;
		private String name;

		public Worker(CountDownLatch argLatch, String argName) {
			this.latch = argLatch;
			this.name = argName;
		}

		@Override
		public void run() {
			try {
				System.out.println("I am thread : " + this.name);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.latch.countDown();
			}
		}
	}

	public static int searchInSortedRotatedArray(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;

		int counter = 0;
		while (low <= high) {
			System.out.println(++counter);
			int mid = (low + high) / 2;
			// { 4, 1, 3, 4, 4, 4 }
			if (nums[mid] == target) {
				return mid;
			} else if (nums[low] < nums[mid]) {
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (nums[mid] < nums[high]) {
				if (nums[mid] <= target && target < nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				low++;
			}
		}

		return -1;
	}

	public static int binSearch(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (x == a[mid]) {
				return mid;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int binSearchRecursion(int[] a, int low, int high, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		if (low > high) {
			return -1;
		}
		int index = -1;
		int mid = low + (high - low) / 2;
		if (x == a[mid]) {
			return mid;
		} else if (x < a[mid]) {
			return binSearchRecursion(a, low, mid - 1, x);
		}
		return binSearchRecursion(a, mid + 1, high, x);
	}

	public static int findFirstOccurence(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;
		int index = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (x == a[mid]) {
				index = mid;
				high = mid - 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return index;
	}

	public static int findLastOccurence(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;// This is to avoid overflows
			if (x == a[mid]) {
				index = mid;
				low = mid + 1;
			} else if (x < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;

	}

	public static int findPivot(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			// CAse 1;
			// if low == high, then return low since its having only one element

			if (a[low] == a[high]) {
				return low;
			}

			int mid = (low + high) / 2;
			int prev = (mid - 1 + a.length) % a.length;
			int next = (mid + 1) % a.length;

			// case 2:
			if (a[mid] < a[prev] && a[mid] < a[high]) {
				return mid;
			} else if (a[low] <= a[mid]) {
				// case 3. check if the first half is sorted or not;
				low = mid + 1;
			} else if (a[mid] <= a[high]) {
				// case 4:
				high = mid - 1;
			}

		}

		return -1;
	}

	public static int findNoOfOccurences(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int first = findFirstOccurence(a, x);
		int last = findLastOccurence(a, x);
		return (last - first + 1);

	}

	public static int findInSortedRotatedArray(int[] a, int x) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int low = 0;
		int high = a.length - 1;

		// int[] a = { 15, 18, 19, 20, 2, 3, 6, 12 };

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (x == a[mid]) {
				return mid;
			} else if (a[low] < a[mid]) {
				if (a[low] <= x && x < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (a[mid] < a[high]) {
				if (a[mid] < x && x <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				low++;
			}

		}

		return -1;
	}

	public static int findPivotInSortedRotatedArray(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}

		// {4,4,4,4,1,3}
		// { 15, 18, 19, 20, 2, 3, 6, 12 };

		int low = 0;
		int high = a.length - 1;
		int len = a.length;

		while (low <= high) {
			if (a[low] == a[high]) {
				return low;
			}
			int mid = low + (high - low) / 2;

			int next = (mid + 1) % len;
			int prev = (mid - 1 + len) % 2;
			if (a[mid] < a[prev] && a[mid] < a[next]) {
				return mid;
			} else if (a[low] <= a[mid]) {
				low = mid + 1;
			} else if (a[mid] <= a[high]) {
				high = mid - 1;
			} else {
				low++;
			}

		}

		return -1;
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		Thread t1 = new Thread(new Worker(latch, "T1"));
		Thread t2 = new Thread(new Worker(latch, "T2"));
		Thread t3 = new Thread(new Worker(latch, "T3"));
		Thread t4 = new Thread(new Worker(latch, "T4"));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		latch.await();

		System.out.println("Done with all tasks");
		int[] arr = { 3, 4, 4, 4, 4, 1 };
		System.out.println("Found at index : " + searchInSortedRotatedArray(arr, 1));
		int[] a = { 15, 18, 19, 20, 2, 3, 6, 12 };
		System.out.println(findPivot(a));
		int[] b = { 2, 3, 6, 12, 15, 18, 19, 20 };

		System.out.println("found at : " + binSearch(b, 19));
		System.out.println("Recursion found at : " + binSearchRecursion(b, 0, b.length, 3));
		int[] c = { 2, 3, 6, 6, 6, 12, 15, 18, 19, 20 };
		System.out.println("find first occurence at : " + findFirstOccurence(c, 6));

		System.out.println("find first occurence at : " + findLastOccurence(c, 6));
		System.out.println("find first occurence at : " + findNoOfOccurences(c, 6));

		int[] p = { 4, 1, 3, 4, 4, 4 };
		System.out.println("Pivot is : " + findPivotInSortedRotatedArray(p));

		int[] ab = { 4, 1, 4, 4, 4, 4 };
		System.out.println("Pivot is : " + findInSortedRotatedArray(ab, 1));

	}

}
