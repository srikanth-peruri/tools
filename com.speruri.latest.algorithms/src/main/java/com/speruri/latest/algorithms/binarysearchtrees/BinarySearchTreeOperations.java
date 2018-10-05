package com.speruri.latest.algorithms.binarysearchtrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeOperations {

	private Node root;

	public static class LinkedListNode {

		int data;
		LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}
	}

	public static class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}
	}

	public void insert(int data) {
		this.root = insert(root, data);
	}

	private Node insert(Node n, int data) {
		// Check whether this node is null
		if (n == null) {
			return new Node(data);
		}

		if (data > n.data) {
			n.right = insert(n.right, data);
		} else {
			n.left = insert(n.left, data);
		}

		return n;
	}

	public static void printBSTWithBFS(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		Node c;
		while (!q.isEmpty()) {
			c = q.poll();
			System.out.print(c + " ");
			if (c.left != null) {
				q.add(c.left);
			}
			if (c.right != null) {
				q.add(c.right);
			}
		}
	}

	public static void printInOrder(Node node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node + " ");
		printInOrder(node.right);
	}

	public static void printpreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node + " ");
		printInOrder(node.left);
		printInOrder(node.right);
	}

	public void delete(int data) {
		this.root = delete(root, data);
	}

	public Node delete(Node node, int x) {
		if (node == null) {
			return null;
		}
		if (x < node.data) {
			node.left = delete(node.left, x);
		} else if (x > node.data) {
			node.right = delete(node.right, x);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			int minValue = findMin(node.right);
			node.data = minValue;
			node.right = delete(node.right, minValue);
		}
		return node;
	}

	public static int findMin(Node right) {
		int minValue = right.data;
		Node c = right;
		while (c != null) {
			minValue = c.data;
			c = c.left;
		}

		return minValue;
	}

	public class PreIndex {
		public int index = 0;

		public void increment() {
			index++;
		}
	}

	public void constructBSTFromPreorder(int[] a) {
		// The idea here is that we can use ranges to calculate if the current
		// value falls under this rangs and then create left or right //nodes
		// First initialize the min and max values with integer min and integer
		// max values.
		// Then create the left node if the value falls between the min and key
		// and create right if the value falls between key and max
		Node root = constructBSTFromPreorder(a, new PreIndex(), a[0], Integer.MIN_VALUE, Integer.MAX_VALUE, a.length);

		printInOrder(root);
	}

	public Node constructBSTFromPreorder(int[] a, PreIndex preIndex, int key, int min, int max, int size) {
		// Check whether the index >= size
		if (preIndex.index >= size) {
			return null;
		}

		Node node = null;
		if (key > min && key < max) {
			node = new Node(key);
			preIndex.increment();

			if (preIndex.index < size) {
				node.left = constructBSTFromPreorder(a, preIndex, a[preIndex.index], min, key, size);
				node.right = constructBSTFromPreorder(a, preIndex, a[preIndex.index], key, max, size);
			}

		}

		return node;

	}

	public void convertBTtoBST(Node node) {
		if (node == null) {
			return;
		}
		// First iterate the whole tree and populate the list
		List<Integer> list = new ArrayList<>();
		populatelist(node, list);
		// Now sort the elements in the list
		Collections.sort(list);
		// Then perform an inorder traversal and update the node values
		updateNodesWithInOrderTraversal(node, list, 0);
		// Print the inorder traversal of the tree
		System.out.println("BT to BST");
		printInOrder(node);
	}

	public void populatelist(Node node, List<Integer> list) {
		if (node == null || list == null) {
			return;
		}
		populatelist(node.left, list);
		list.add(node.data);
		populatelist(node.right, list);
	}

	public int updateNodesWithInOrderTraversal(Node node, List<Integer> list, int index) {
		if (node == null || list == null) {
			return index;
		}

		int i = updateNodesWithInOrderTraversal(node.left, list, index);
		node.data = list.get(i);
		i = updateNodesWithInOrderTraversal(node.right, list, i + 1);
		return i;
	}

	public void convertSortedLinkedListToBST(LinkedListNode lNode) {
		if (lNode == null) {
			return;
		}
		Node root = new Node(lNode.data);

		convertSortedLinkedListToBST(root, lNode.next);
		System.out.println("\n Linked list to BST");
		printInOrder(root);

	}

	public Node convertSortedLinkedListToBST(Node root, LinkedListNode lNode) {
		if (root == null && lNode != null) {
			return new Node(lNode.data);
		}
		root.left = convertSortedLinkedListToBST(root.left, lNode);
		root.right = convertSortedLinkedListToBST(root.right, lNode.next);
		return root;
	}

	public void sortedArrayToBST(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		System.out.println("\nSorted Array to BST");
		printInOrder(sortedArrayToBST(a, 0, a.length - 1));
	}

	public Node sortedArrayToBST(int[] a, int low, int high) {
		if (low > high) {
			return null;
		}

		int mid = (low + high) / 2;
		Node node = new Node(a[mid]);
		node.left = sortedArrayToBST(a, low, mid - 1);
		node.right = sortedArrayToBST(a, mid + 1, high);
		return node;
	}

	public void getGreaterSum(Node node) {
		getGreaterSum(node, 0);
		System.out.println("Greated sum is ");
		printInOrder(node);
	}

	public static int count = 0;

	public int getGreaterSum(Node node, int totalSum) {
		if (node == null) {
			return 0;
		}

		getGreaterSum(node.right, count);
		count = count + node.data;
		node.data = count - node.data;
		getGreaterSum(node.left, count);
		return count;
	}

	public void unbalancedBSTToBalancedBST(Node node) {
		if (node == null) {
			return;
		}

		// Since its BST, we we do a inorder traversal, then we will get the
		// sorted array for sure.
		List<Node> list = new ArrayList<>();
		populateTheList(node, list);
		// Then create a BST recursively by iterating throught that array
		System.out.println("Unbalanced BST to balanced BST");
		printpreOrder(createBalancedBST(list, 0, list.size()));

	}

	public void populateTheList(Node node, List<Node> list) {
		if (node == null || list == null) {
			return;
		}
		// perform the inroder traversal
		populateTheList(node.left, list);
		list.add(node);
		populateTheList(node.right, list);
	}

	public void mergeTwoBinaryTrees(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(node1);
		Node c;

		while (!q.isEmpty()) {
			c = q.poll();
			this.insert(node2, c.data);
			if (c.left != null) {
				q.add(c.left);
			}

			if (c.right != null) {
				q.add(c.right);
			}
		}
		System.out.println("\nAfter merging two BST");

		printInOrder(node2);
	}

	public void mergeTwoBST(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return;
		}
		// Copy the nodes from both the tree's to the list
		List<Node> nodeList = new ArrayList<>();
		copyToList(node1, nodeList);
		copyToList(node2, nodeList);

		// Sort the list based on the node data
		Comparator<Node> comp = new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if (n1.data == n2.data) {
					return 0;
				} else if (n1.data < n2.data) {
					return -1;
				}
				return 1;
			}
		};
		nodeList.sort(comp);
		// Now the list was sorted, now perform the inorder traversal and merge
		// BST's
		printInOrder(mergeTrees(nodeList, 0, nodeList.size() - 1));

	}

	public Node createBalancedBST(List<Node> list, int low, int high) {
		if (low > high) {
			return null;
		}
		Node node = null;
		if (low < list.size()) {
			int mid = (low + high) / 2;
			node = list.get(mid);
			node.left = createBalancedBST(list, low, mid - 1);
			node.right = createBalancedBST(list, mid + 1, high);
		}
		return node;

	}

	private Node mergeTrees(List<Node> list, int low, int high) {
		if (low > high) {
			return null;
		}
		Node node = null;
		if (low < list.size()) {
			int mid = (low + high) / 2;
			node = list.get(mid);
			node.left = mergeTrees(list, low, mid - 1);
			node.right = mergeTrees(list, mid + 1, high);
		}
		return node;
	}

	public void copyToList(Node node, List<Node> list) {
		if (node == null || list == null) {
			return;
		}
		copyToList(node.left, list);
		list.add(node);
		copyToList(node.right, list);
	}

	public static void printBSTElement(int a[], int start, int end) {
		if (a == null || a.length == 0 || start > end) {
			return;
		}

		// we can get the left sub tree using the l = 2 * start + 1
		printBSTElement(a, 2 * start + 1, end);
		System.out.print(a[start] + " ");
		// we can get the left sub tree using the r = 2 * start + 2
		printBSTElement(a, 2 * start + 2, end);

	}

	public static void createBSTFromArray(int a[]) {
		if (a == null || a.length == 0) {
			return;
		}
		java.util.Arrays.sort(a);
		Node root = createBSTFromArray(a, 0, a.length - 1);
		System.out.println("\nBST from array is :");
		printInOrder(root);
	}

	public boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		// Check whether the data is greater than min or not.
		if (node.data < min && node.data > max) {
			return false;
		}

		// Now recursively call
		return isBST(node.left, min, node.data - 1) && isBST(node.right, node.data + 1, max);
	}

	public static Node createBSTFromArray(int[] a, int low, int high) {
		if (low > high) {
			return null;
		}

		Node node = null;
		if (low < a.length) {
			int mid = (low + high) / 2;
			node = new Node(a[mid]);
			node.left = createBSTFromArray(a, low, mid - 1);
			node.right = createBSTFromArray(a, mid + 1, high);
		}

		return node;

	}

	public static void main(String[] args) {

		BinarySearchTreeOperations bst = new BinarySearchTreeOperations();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		printBSTWithBFS(bst.root);
		bst.delete(60);
		System.out.println("\n After deleting :");
		printInOrder(bst.root);
		System.out.println("\nConstructing the BST ");
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		bst.constructBSTFromPreorder(pre);

		Node btRoot = new Node(10);
		btRoot.left = new Node(30);
		btRoot.right = new Node(15);
		btRoot.left.left = new Node(20);
		btRoot.right.right = new Node(5);
		bst.convertBTtoBST(btRoot);

		LinkedListNode llist = new LinkedListNode(1);

		/*
		 * Let us create a sorted linked list to test the functions Created
		 * linked list will be 7.6.5.4.3.2.1
		 */
		llist.next = new LinkedListNode(2);
		llist.next.next = new LinkedListNode(3);
		llist.next.next.next = new LinkedListNode(4);
		llist.next.next.next.next = new LinkedListNode(5);
		llist.next.next.next.next.next = new LinkedListNode(6);
		llist.next.next.next.next.next.next = new LinkedListNode(7);
		llist.next.next.next.next.next.next.next = new LinkedListNode(8);
		bst.convertSortedLinkedListToBST(llist);

		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		bst.sortedArrayToBST(arr);

		Node sumnode = new Node(11);
		sumnode.left = new Node(2);
		sumnode.right = new Node(29);
		sumnode.left.left = new Node(1);
		sumnode.left.right = new Node(7);
		sumnode.right.left = new Node(15);
		sumnode.right.right = new Node(40);
		sumnode.right.right.left = new Node(35);
		bst.getGreaterSum(sumnode);

		Node ubNode = new Node(10);
		ubNode.left = new Node(8);
		ubNode.left.left = new Node(7);
		ubNode.left.left.left = new Node(6);
		ubNode.left.left.left.left = new Node(5);
		bst.unbalancedBSTToBalancedBST(ubNode);

		Node root = new Node(100);
		root.left = new Node(50);
		root.right = new Node(300);
		root.left.left = new Node(20);
		root.left.right = new Node(70);

		/*
		 * Creating following tree as second balanced BST 80 / \ 40 120
		 */

		Node root1 = new Node(80);
		root1.left = new Node(40);
		root1.right = new Node(120);

		// bst.mergeTwoBinaryTrees(root, root1);
		System.out.println("After performing merge");
		bst.mergeTwoBST(root, root1);
		int bstArr[] = { 4, 2, 5, 1, 3 };

		System.out.println("Printing the BST array");
		printBSTElement(bstArr, 0, bstArr.length - 1);

		int[] bArray = new int[] { 1, 2, 3, 4, 5 };
		createBSTFromArray(bstArr);
	}

}
