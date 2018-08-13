package com.speruri.latest.algorithms.linkedlists;

public class Node<E> {

	E data;
	Node next;

	public Node(E argData) {
		data = argData;
		next = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}
