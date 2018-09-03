package com.speruri.latest.algorithms.stacks;

import java.util.Stack;

import com.speruri.latest.algorithms.linkedlists.Node;

public class ReversalUsingStack {

	public static void reverseString(String str) {
		if (str == null || str.length() == 0) {
			return;
		}

		Stack<Character> charStack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			charStack.push(str.charAt(i));
		}

		while (!charStack.isEmpty()) {
			System.out.print(charStack.pop());
		}
	}

	private static Node reverseLinkedList(Node<Integer> node) {
		if (node == null) {
			return node;
		}

		Stack<Node> intStack = new Stack<Node>();
		Node<Integer> current = node;
		while (current != null) {
			intStack.push(current);
			current = current.getNext();
		}

		Node top = intStack.pop();
		Node head = top;

		while (!intStack.isEmpty()) {
			Node cur = intStack.pop();
			top.setNext(cur);
			cur.setNext(null);
			top = cur;
		}

		return head;
	}

	private static void printLinkedList(Node node) {
		if (node == null) {
			return;
		}
		Node current = node;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
	}

	public static void main(String[] args) {
		reverseString("Srikanth");
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		Node<Integer> node6 = new Node<Integer>(6);
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		System.out.println();
		System.out.println("Before Reversing");
		printLinkedList(head);
		System.out.println();
		System.out.println("After Reversing");
		printLinkedList(reverseLinkedList(head));
	}

}
