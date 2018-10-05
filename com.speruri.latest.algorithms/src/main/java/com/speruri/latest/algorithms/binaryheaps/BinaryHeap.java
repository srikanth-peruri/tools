package com.speruri.latest.algorithms.binaryheaps;

import com.speruri.latest.algorithms.sorting.CustomArrayUtils;

public class BinaryHeap {

	int capacity;
	int currentHeapIndex;
	int[] a;

	public BinaryHeap(int cap) {
		this.capacity = cap;
		this.a = new int[cap];
		this.currentHeapIndex = 0;
	}

	public int getParent(int index) {
		return (index - 1) / 2;
	}

	public static int getLeft(int index) {
		return (2 * 1 + 1);
	}

	public static int getRight(int index) {
		return (2 * 1 + 2);
	}

	public int getMin() {
		return a[0];
	}

	// First insert the element in the current heap index
	public void insertKey(int x) {
		if (currentHeapIndex >= capacity) {
			System.out.println("CAnnot insert more than capacity");
			return;
		}
		// inser the element at current heap index
		a[currentHeapIndex] = x;
		int i = currentHeapIndex;
		// increment the index
		currentHeapIndex++;

		// Ceck whether the inserted item is lesser than its parent
		while (i != 0 && a[getParent(i)] > a[i]) {
			// if lesser than parent, then swap
			CustomArrayUtils.swap(a, getParent(i), i);
			// assign parent to i
			i = getParent(i);
		}
	}

	// To set the new value at an index, we should first insert the value at
	// that index
	// and then swap if its parent is lesser than the curent
	public void decreaseKey(int x, int newValue) {
		if (x >= this.capacity) {
			return;
		}
		this.a[x] = newValue;
		int i = x;
		while (i != 0 && a[getParent(i)] > a[i]) {
			CustomArrayUtils.swap(a, i, getParent(i));
			i = getParent(i);
		}
	}

	// in case of delete, first decrese the key at the index
	// and then call extractmin
	public void deleteKey(int x) {
		if (x > currentHeapIndex) {
			return;
		}
		decreaseKey(x, Integer.MIN_VALUE);
		extractMin();
	}

	public int extractMin() {
		if (currentHeapIndex <= 0) {
			return Integer.MIN_VALUE;
		}

		if (currentHeapIndex == 1) {
			currentHeapIndex--;
			return a[currentHeapIndex];
		}

		int root = a[0];
		a[0] = a[a.length - 1];
		currentHeapIndex--;
		minHeapify(0);
		return root;
	}

	public void minHeapify(int index) {
		if (index > currentHeapIndex) {
			return;
		}

		int smallest = index;
		int left = getLeft(index);
		int right = getRight(index);

		if (left < currentHeapIndex && a[left] < a[index]) {
			smallest = left;
		}

		if (right < currentHeapIndex && a[right] < a[smallest]) {
			smallest = right;
		}

		if (smallest != index) {
			CustomArrayUtils.swap(a, index, smallest);
			minHeapify(smallest);
		}

	}

	public void printMinHeap() {
		CustomArrayUtils.printArray(a);
	}

	public static void ascendingSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			performMinHeap(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			performMinHeap(arr, i, 0);
		}
	}

	public static void performMinHeap(int[] arr, int n, int i) {
		if (arr == null || arr.length == 0 || i >= arr.length) {
			return;
		}

		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] < arr[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r] < arr[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			performMinHeap(arr, n, largest);
		}
	}

	public static void minHeapify(int[] a, int n, int i) {
		if (a == null || a.length == 0 || i >= a.length) {
			return;
		}

		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && a[left] < a[smallest]) {
			smallest = left;
		}

		if (right < n && a[right] < a[smallest]) {
			smallest = right;
		}
		if (smallest != i) {
			CustomArrayUtils.swap(a, smallest, i);
			minHeapify(a, n, smallest);
		}
	}

	public static void sortAscending(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int n = a.length;
		for (int i = 0; i < n / 2 - 1; i--) {
			minHeapify(a, n, i);
		}

		// now iterate through the array and then check for each element with
		// the first element
		for (int i = n - 1; i >= 0; i--) {
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			minHeapify(a, i, 0);
		}

	}

	public static void maxHeapify(int[] a, int n, int index) {
		if (a == null || a.length == 0 || index >= a.length) {
			return;
		}

		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		if (left < n && a[left] > a[largest]) {
			largest = left;
		}
		if (right < n && a[right] > a[largest]) {
			largest = right;
		}

		if (largest != index) {
			CustomArrayUtils.swap(a, index, largest);
			maxHeapify(a, n, largest);
		}
	}
	
	public void BSTToHeap(int[] a){
		
	}

	public static void main(String[] args) {
		BinaryHeap h = new BinaryHeap(11);
		h.insertKey(3);
		h.insertKey(2);
		h.deleteKey(1);
		h.insertKey(15);
		h.insertKey(5);
		h.insertKey(4);
		h.insertKey(45);
		System.out.println("Extract min : " + h.extractMin());
		System.out.println("Min element : " + h.getMin());
		h.decreaseKey(2, 1);
		System.out.println("Min element : " + h.getMin());
		h.printMinHeap();
		System.out.println("Sorting array ");
		int[] arr = new int[] { 6, 5, 4, 3, 2, 1 };
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6 };
		ascendingSort(arr1);
		CustomArrayUtils.printArray(arr1);
	}
}
