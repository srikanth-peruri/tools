package com.speruri.latest.algorithms.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListOperations {

	Node head;

	public static class Node {
		int data;
		Node next;

		public Node(int argData) {
			this.data = argData;
		}

		@Override
		public java.lang.String toString() {
			return this.data + " ";
		}
	}

	public void insertFirst(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	public void printAllNodes(Node argNode) {
		if (argNode == null) {
			return;
		}

		Node current = argNode;
		while (current != null) {
			System.out.print(current);
			current = current.next;
		}
	}

	public void deleteNode(int data) {
		int counter = 0;
		if (head == null) {
			System.out.println(counter);
			return;
		}

		if (head.data == data) {
			head = head.next;
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
			counter++;
		}
	}

	public void reverseLinkedList() {
		if (head == null) {
			return;
		}
		Node prev = null;
		Node next = null;
		Node current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void findMidPoint() {
		if (head == null) {
			return;
		}

		Node slowPtr = head;
		Node fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		System.out.println("Mid Is : " + slowPtr);

	}

	public void findMidPointByOdd() {
		if (head == null) {
			return;
		}

		Node current = head;
		Node mid = head;

		int counter = 0;
		while (current != null) {
			if (counter % 2 == 1) {
				mid = mid.next;
			}
			current = current.next;
			counter++;
		}

		System.out.println("Mid Is : " + mid);

	}

	public void findNthNodeFromLast(int n) {
		if (head == null) {
			return;
		}

		Node mainPtr = null;
		Node refPtr = head;

		int counter = 0;

		while (counter < n && refPtr != null) {
			refPtr = refPtr.next;
			counter++;
		}

		if (refPtr != null) {
			mainPtr = head;
		}

		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}

		System.out.println("Nth node from last is : " + mainPtr);

	}

	public boolean detectLoop() {
		if (head == null) {
			return false;
		}
		Node mainPtr = head;
		java.util.HashSet<Node> set = new HashSet<Node>();

		while (mainPtr != null) {
			if (set.contains(mainPtr)) {
				return true;
			}
			set.add(mainPtr);
			mainPtr = mainPtr.next;
		}

		return false;
	}

	public boolean FloyddetectLoop() {
		if (head == null) {
			return false;
		}
		Node slowPtr = head;
		Node fastPtr = head;

		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}

		return false;
	}

	public void removeDuplicatesFromUnsortedLinkedList(Node node) {
		if (node == null) {
			return;
		}

		Set<Integer> set = new HashSet();
		Node current = node;
		Node prev = null;

		while (current != null) {

			if (set.contains(current.data)) {
				prev.next = current.next;
			} else {
				prev = current;
				set.add(current.data);
			}
			current = current.next;
		}
		System.out.println("After removing duplicates");
		printAllNodes(prev);
	}

	public static void main(String[] args) {
		LinkedListOperations linkedList = new LinkedListOperations();
		linkedList.insertLast(20);
		linkedList.insertLast(4);
		linkedList.insertLast(15);
		linkedList.insertLast(16);
		// linkedList.head.next.next.next.next = linkedList.head;
		// linkedList.insertLast(5);
		System.out.println("Loop ? " + linkedList.detectLoop());
		System.out.println("Loop ? " + linkedList.FloyddetectLoop());
		linkedList.printAllNodes(linkedList.head);
		linkedList.findNthNodeFromLast(1);
		// linkedList.deleteNode(3);
		// System.out.println("\nAfter delete");
		// linkedList.printAllNodes();
		System.out.println("\nAfter reversing the nodes");
		linkedList.reverseLinkedList();
		linkedList.printAllNodes(linkedList.head);

		linkedList.findMidPoint();
		linkedList.findMidPointByOdd();

		Node start = new Node(10);
		start.next = new Node(12);
		start.next.next = new Node(11);
		start.next.next.next = new Node(11);
		start.next.next.next.next = new Node(12);
		start.next.next.next.next.next = new Node(11);
		start.next.next.next.next.next.next = new Node(10);
		linkedList.removeDuplicatesFromUnsortedLinkedList(start);
	}

}
