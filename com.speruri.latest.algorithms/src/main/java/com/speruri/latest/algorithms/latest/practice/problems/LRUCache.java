package com.speruri.latest.algorithms.latest.practice.problems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node end;
	private int capacity;

	public LRUCache(int argCapacity) {
		this.capacity = argCapacity;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			Node n = map.get(key);
			remove(n);
			setHead(n);
		}
		return -1;

	}

	public void put(int key, int value) {
		// There are two cases
		if (map.containsKey(key)) {
			Node n = map.get(key);
			n.value = value;
			remove(n);
			setHead(n);
		} else {
			Node newnode = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
			}
			setHead(newnode);
			map.put(key, newnode);
		}
	}

	private void remove(Node argNode) {
		if(argNode.prev != null){
			argNode.prev.next = argNode.next;
		} else{
			head = argNode.next;
		}
		
		if(argNode.next != null){
			argNode.next.prev = argNode.prev;
		} else{
			end = argNode.prev;
		}
		
	}

	private void setHead(Node newNode) {
		newNode.next = head;
		newNode.prev = null;

		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		if (end == null) {
			end = newNode;
		}
	}

	static class Node {
		int key;
		int value;
		Node next;
		Node prev;

		public Node(int argKey, int argValue) {
			this.key = argKey;
			this.value = argValue;
		}
	}

}
