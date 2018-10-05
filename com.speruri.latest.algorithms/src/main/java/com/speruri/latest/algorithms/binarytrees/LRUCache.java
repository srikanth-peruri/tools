package com.speruri.latest.algorithms.binarytrees;

import java.util.Map;
import java.util.HashMap;

public class LRUCache {

	private Map<Integer, LRUNode> keyToLRUNodeMap;
	private LRUNode head;
	private LRUNode end;
	private int capacity;

	public class LRUNode {
		int key;
		int value;
		LRUNode next;
		LRUNode prev;

		public LRUNode(int argKey, int argValue) {
			this.key = argKey;
			this.value = argValue;
		}

		@Override
		public String toString() {
			return "LRUNode [key=" + key + ", value=" + value + "]";
		}
	}

	public LRUCache(int argSize) {
		this.capacity = argSize;
		keyToLRUNodeMap = new HashMap<Integer, LRUNode>();
	}

	// Implement the put and get methods

	public int get(int key) {
		if (keyToLRUNodeMap.containsKey(key)) {
			LRUNode node = keyToLRUNodeMap.get(key);
			removeNode(node);
			setHeadNode(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (keyToLRUNodeMap.containsKey(key)) {
			// then this is the recently accessed and move it to first
			LRUNode node = keyToLRUNodeMap.get(key);
			node.value = value;
			removeNode(node);
			setHeadNode(node);
		} else {
			// If not present, then create a new node with the key and value and
			// set it to map
			LRUNode newNode = new LRUNode(key, value);
			if (keyToLRUNodeMap.size() >= capacity) {
				LRUNode oldNode = keyToLRUNodeMap.get(end.key);
				removeNode(oldNode);
				keyToLRUNodeMap.remove(oldNode.key);
			}
			setHeadNode(newNode);
			keyToLRUNodeMap.put(key, newNode);
		}
	}

	private void removeNode(LRUNode node) {
		// While removing the node, we will have 3 cases
		// Case 1 : this might be in middle of the nodes
		// Case 2 : might be the head
		// Case 3 : might be the end
		if (node != null) {
			// Get prev
			LRUNode prev = node.prev;
			// Get next
			LRUNode next = node.next;
			// If prev is null, then this is the head
			if (prev != null) {
				// Else set the prev next = this next
				prev.next = next;
			} else {
				head = next;
			}
			// If the next is null, then this is the end node
			if (next != null) {
				// If not null, then set the next prev = this prev
				next.prev = prev;
			} else {
				end = prev;
			}
		}
	}

	private void setHeadNode(LRUNode node) {
		// To set this first node, we need to do,
		// this.next to head;
		node.next = head;
		// Set prev to null
		node.prev = null;
		// If head is not null, then set the head prev to this node.
		if (head != null) {
			head.prev = node;
		}
		// then set the head
		head = node;
		// If the end is null, then set it to head
		if (end == null) {
			end = head;
		}
	}

	public void printLRUCacheList() {
		System.out.println("=================");
		LRUNode node = head;
		while (node != null) {
			System.out.println(node);
			node = node.next;
		}
		System.out.println("=================");
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(5);
		lruCache.put(1, 10);
		lruCache.put(2, 20);
		lruCache.put(3, 30);
		lruCache.put(4, 40);
		lruCache.put(5, 50);
		lruCache.printLRUCacheList();

		lruCache.put(6, 60);
		lruCache.put(5, 55);
		lruCache.printLRUCacheList();

	}

}
