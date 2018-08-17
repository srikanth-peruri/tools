package com.speruri.latest.algorithms.doublylinkedlists;

public class DNode<E> {

	DNode prev;
	E data;
	DNode next;

	public DNode() {
		this.next = null;
		this.prev = null;
	}

	@Override
	public String toString() {
		return "DNode [prev=" + prev + ", data=" + data + ", next=" + next + "]";
	}

}
