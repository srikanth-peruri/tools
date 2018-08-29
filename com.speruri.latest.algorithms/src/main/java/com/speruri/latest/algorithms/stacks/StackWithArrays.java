package com.speruri.latest.algorithms.stacks;

public class StackWithArrays {

	int[] array;

	int index = 0;

	public StackWithArrays(int length) {
		this.array = new int[length];
	}

	public void push(int data) {
		if (!isFull()) {
			this.array[index] = data;
			index = index + 1;
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int poppedItem = this.array[index - 1];
			this.array[index - 1] = -1;
			index--;
			return poppedItem;
		}
		return -1;
	}

	public int peek() {
		if (!isEmpty()) {
			return this.array[index - 1];
		}
		return -1;
	}

	public boolean isEmpty() {
		return (index == -1);
	}

	public boolean isFull() {
		return index == this.array.length;
	}

	public void displayStack() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		StackWithArrays stack = new StackWithArrays(5);
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.displayStack();

		System.out.println();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.displayStack();
		System.out.println();
		System.out.println(stack.peek());

	}
}
