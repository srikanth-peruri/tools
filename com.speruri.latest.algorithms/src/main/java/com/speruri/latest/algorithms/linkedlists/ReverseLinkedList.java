package com.speruri.latest.algorithms.linkedlists;

public class ReverseLinkedList {

	Node<String> head;

	public void reverseLinkedList() {
		if (head == null) {
			return;
		}

		Node<String> prev = null;
		Node<String> current = head;
		Node<String> next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void recursivereverse(Node node) {
		if (node == null || node.next == null) {
			head = node;
			return;
		}
		Node nextNode = node.next;
		Node currentNode = node;
		recursivereverse(nextNode);
		nextNode.next = currentNode;
		currentNode.next = null;
	}
	// 1,2,3,4,5,6

	public static void main(String[] args) {

	}
}
