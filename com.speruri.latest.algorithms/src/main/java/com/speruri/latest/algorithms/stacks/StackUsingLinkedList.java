package com.speruri.latest.algorithms.stacks;

public class StackUsingLinkedList {

	StackLinkedList stack;

	public StackUsingLinkedList() {
		this.stack = new StackLinkedList();
	}

	public void push(int argData) {
		this.stack.push(argData);
	}

	public int pop() {
		return this.stack.pop();
	}

	public int peek() {
		return this.stack.peek();
	}

	public void printStack() {
		this.stack.printStack();
	}

	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		stack.printStack();
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println();
		stack.printStack();
		
	}

}
