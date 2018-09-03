package com.speruri.latest.algorithms.stacks;

public class StackLinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int argData) {
			this.data = argData;
			this.next = null;
		}
	}

	public void push(int argData) {
		Node node = new Node(argData);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public int pop() {
		if (head == null) {
			throw new RuntimeException("Stack is empty");
		}
		int data = head.data;
		head = head.next;
		return data;
	}

	public int peek() {
		if (head == null) {
			throw new RuntimeException("Stack is empty");
		}
		return head.data;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	private int getSize() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void printStack() {
		if (!this.isEmpty()) {
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
		}
	}
}
