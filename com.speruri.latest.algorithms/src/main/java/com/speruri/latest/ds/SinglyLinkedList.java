package com.speruri.latest.ds;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {

	private Node head;

	public static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}
	}

	public void insertFirst(int data) {
		insertFirst(head, data);
	}

	private void insertFirst(Node node, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	private void insertLast(int data) {
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

	public void printNodes() {
		if (head == null) {
			return;
		}

		Node current = head;
		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
	}

	public void deleteItem(int data) {
		if (head == null) {
			return;
		}

		// Check if the head is matching with the data
		if (head.data == data) {
			head = head.next;
			return;
		}

		// Check for the other nodes
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				break;
			}
			current = current.next;
		}
	}

	public void printNthNodeFromLast(int index) {
		if (head == null) {
			return;
		}

		List<Node> list = new ArrayList<Node>();

		Node current = head;
		while (current != null) {
			list.add(current);
			current = current.next;
		}

		Node nthNode = list.get(list.size() - index);
		System.out.println("Nth node is " + nthNode);
	}

	public int countNodes() {
		if (head == null) {
			return 0;
		}

		int count = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public void findNthNodeFromLast(int index) {
		if (head == null) {
			return;
		}
		Node mainPtr = head;
		Node refPtr = head;
		int count = 0;
		while (count < index) {
			refPtr = refPtr.next;
			count++;
		}
		while (refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		System.out.println("Nth node from last is : " + mainPtr.data);

	}

	public void findMidNode() {
		if (head == null) {
			return;
		}

		Node current = head;
		Node mid = head;

		int count = 0;

		while (current != null) {
			if (count % 2 == 1) {
				mid = mid.next;
			}
			count++;
			current = current.next;
		}

		System.out.println("Mid point is : " + mid);

	}

	public void detectCycle() {
		if (head == null) {
			return;
		}

		Node slowPtr = head;
		Node fastPtr = head;

		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				System.out.println("Loop found");
				return;
			}
		}
		System.out.println("Loop not found");
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(5);
		list.printNodes();
		System.out.println();
		list.head = null;
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(5);
		list.insertLast(6);
		list.insertLast(7);
		list.printNodes();
		// list.deleteItem(1);
		System.out.println("\nAfter deleting");
		list.printNodes();
		// System.out.println("\nNodes count : " + list.countNodes());
		// list.printNthNodeFromLast(5);
		System.out.println("Node from last nth\n");
		list.findNthNodeFromLast(3);
		System.out.println("Mid node is \n");
		list.findMidNode();
		
		SinglyLinkedList llist = new SinglyLinkedList(); 
		  
        llist.insertFirst(20); 
        llist.insertFirst(4); 
        llist.insertFirst(15); 
        llist.insertFirst(10); 
          
        /*Create loop for testing */
//        llist.head.next.next.next.next = llist.head; 
        llist.detectCycle();
	}

}
