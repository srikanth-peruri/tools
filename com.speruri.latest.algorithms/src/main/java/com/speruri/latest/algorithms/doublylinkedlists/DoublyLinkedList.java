package com.speruri.latest.algorithms.doublylinkedlists;

public class DoublyLinkedList<E> {

	DNode head;
	DNode last;

	void addNodeAtFirst(E argData) {
		DNode<E> node = new DNode<E>();
		node.data = argData;
		if (head == null) {
			// nothing to do, this is the first node to insert
			last = node;
		} else {
			node.next = head;
			head.prev = node;
		}
		head = node;
	}

	void addNodeAtLast(E argData) {
		DNode<E> node = new DNode<E>();
		node.data = argData;

		if (last == null) {
			// nothing to do
			head = node;
		} else {
			node.prev = last;
			last.next = node;
		}
		last = node;
	}

	void insertAfter(E argData, E source) {
		if (head == null) {
			addNodeAtFirst(argData);
		}
		// Create a node
		DNode<E> node = new DNode<E>();
		node.data = argData;

		DNode<E> n = head;

		int counter = 0;
		// Iterate the whole list to find the data
		while (n != null) {
			if (n.data.equals(source)) {
				// get the prev and next nodes
				DNode next = n.next;

				// set the node prev to the current node
				node.prev = n;
				// set the next to the current node
				node.next = next;

				// set the
				n.next = node;
				if (next != null) {
					next.prev = node;
				} else {
					last = node;
				}
				break;
			}
			n = n.next;
			counter++;
		}

	}

	void insertBefore(E argData, E source) {
		if (head == null) {
			addNodeAtFirst(argData);
		}

		DNode<E> node = new DNode<E>();
		node.data = argData;

		DNode n = head;
		while (n != null) {
			if (n.data.equals(source)) {
				DNode<E> prev = n.prev;
				DNode<E> next = n.next;

				node.next = n;
				node.prev = prev;

				n.prev = node;
				if (prev != null) {
					prev.next = node;
				} else {
					head = node;
				}
				break;

			}
			n = n.next;
		}

	}

	void displayNodesFromStart() {
		if (head != null) {
			DNode n = head;
			while (n != null) {
				System.out.print(" " + n.data);
				n = n.next;
			}
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addNodeAtFirst(1);
		list.addNodeAtFirst(2);
		list.addNodeAtFirst(3);
		list.addNodeAtFirst(4);
//		list.addNodeAtFirst(5);
		list.addNodeAtLast(2);
		list.addNodeAtLast(3);
		list.addNodeAtLast(4);
		list.addNodeAtLast(5);

		list.insertAfter(15, 5);
		list.insertBefore(25, 1);
		list.displayNodesFromStart();
	}

}
