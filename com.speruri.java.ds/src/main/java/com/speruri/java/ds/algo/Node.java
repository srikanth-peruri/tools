package com.speruri.java.ds.algo;

public class Node<E> {

	private E data;
	private Node<E> next;
	
	public Node(E argData) {
		this.data = argData;
		this.next = null;
	}
	
	public E getData() {
		return this.data;
	}
	public void setData(E argData) {
		this.data = argData;
	}
	public Node<E> getNext() {
		return this.next;
	}
	public void setNext(Node<E> argNext) {
		this.next = argNext;
	}
	
	
	
}

