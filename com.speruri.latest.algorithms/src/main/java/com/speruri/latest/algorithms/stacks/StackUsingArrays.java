package com.speruri.latest.algorithms.stacks;

import java.util.Arrays;

public class StackUsingArrays {

	private int[] array;
	private int top = -1;

	public StackUsingArrays(int count) {
		this.array = new int[count];
	}

	public void push(int e) {
		if (this.isFull()) {
			increaseArrayLength();
		}
		this.array[++top] = e;
	}

	public void increaseArrayLength() {
		int newLength = this.array.length * 2;
		this.array = Arrays.copyOf(this.array, newLength);
		System.out.println("Increased length to : " + newLength);
	}

	public boolean isFull() {
		return top == this.array.length - 1;
	}

	public int pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.array[top--];
	}

	public int peek() {
		if (this.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return this.array[top];
	}

	public int getSize() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void printStack() {
		if (!this.isEmpty()) {
			for (int i = 0; i <= top; i++) {
				System.out.print(array[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		StackUsingArrays stack = new StackUsingArrays(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack();
		System.out.println();
		System.out.println("Popping");
		System.out.println(stack.pop());
		stack.printStack();
		System.out.println();
		for (int i = 0; i < 100; i++) {
			stack.push(i + 5);
		}
		stack.printStack();
	}
}
