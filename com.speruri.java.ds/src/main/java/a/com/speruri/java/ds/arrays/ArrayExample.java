package a.com.speruri.java.ds.arrays;

public class ArrayExample {
	public static void main(String[] args) {
		int[] array = new int[5];

		for (int i = 0; i < array.length; i++) {
			// O(1)
			array[i] = i;
		}

		for (int i = 0; i < array.length; i++) {
			// O(1)
			System.out.println(array[i]);
		}

		// For searching an item in the array, it would be a linear search
		// and the time complexity is O(N)
		// O(N) --> Linear search
		// O(logN) --> Binary search trees
		// O(1) --> Hashtables
		int numToCompare = 10;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numToCompare) {
				System.out.println("Found number ...");
				break;
			}
		}
	}
}
