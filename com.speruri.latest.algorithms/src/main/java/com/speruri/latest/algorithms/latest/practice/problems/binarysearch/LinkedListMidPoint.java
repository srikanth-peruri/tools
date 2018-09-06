package com.speruri.latest.algorithms.latest.practice.problems.binarysearch;

import com.speruri.latest.algorithms.linkedlists.Node;

public class LinkedListMidPoint {

	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.setNext(new Node<Integer>(2));
		head.getNext().setNext(new Node<Integer>(3));
		head.getNext().getNext().setNext(new Node<Integer>(4));
		head.getNext().getNext().getNext().setNext(new Node<Integer>(5));
		head.getNext().getNext().getNext().getNext().setNext(new Node<Integer>(6));
		head.getNext().getNext().getNext().getNext().getNext().setNext(new Node<Integer>(7));
		System.out.println(findMidNode(head));
		System.out.println(findMidNodeUsing2Pointer(head));
		
	}

	private static Node<Integer> findMidNode(Node<Integer> head) {
		if (head == null) {
			return null;
		}
		Node<Integer> midNode = head;
		Node<Integer> current = head;
		int counter = 0;
		while (current != null) {
			if (counter % 2 == 1) {
				midNode = midNode.getNext();
			}
			counter++;
			current = current.getNext();
		}
		return midNode;
	}

	private static Node<Integer> findMidNodeUsing2Pointer(Node<Integer> head) {
		if (head == null) {
			return null;
		}

		Node<Integer> slowNode = head;
		Node<Integer> fastNode = head;

		while (fastNode != null && fastNode.getNext() != null) {
			slowNode = slowNode.getNext();
			fastNode = fastNode.getNext().getNext();
		}
		return slowNode;
	}

}
