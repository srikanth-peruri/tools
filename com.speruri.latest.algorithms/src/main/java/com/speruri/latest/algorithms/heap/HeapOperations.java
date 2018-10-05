package com.speruri.latest.algorithms.heap;

public class HeapOperations {

	int size = 0;
	int capacity = 10;
	int[] items;

	private int getLeftChildIndex(int index) {
		// left = 2i + 1
		return (2 * index + 1);
	}

	private int getRightChildIndex(int index) {
		return (2 * index + 2);
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasLeft(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRight(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private int getLeftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	private int getRightChild(int index) {
		return items[getRightChild(index)];
	}

	private int getParent(int index) {
		return items[getParentIndex(index)];
	}

	private void swap(int i, int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	private void ensureCapacity() {
		if (size == capacity) {
			items = java.util.Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	private int peek() {
		if (capacity == 0)
			throw new IllegalStateException();
		return items[0];
	}

	private int poll() {
		if (capacity == 0)
			throw new IllegalStateException();
		int minItem = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return minItem;

	}

	private void add(int data) {
		ensureCapacity();
		items[size++] = data;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		while (this.hasParent(index) && this.getParent(index) < items[index]) {
			swap(this.getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
//		heapifyDown(0);
	}


}
