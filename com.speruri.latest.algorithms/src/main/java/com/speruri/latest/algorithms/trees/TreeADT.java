package com.speruri.latest.algorithms.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class TreeADT {

	private NodeOfTree root;

	public static class NodeOfTree {

		private int data;
		private NodeOfTree left;
		private NodeOfTree right;

		public NodeOfTree(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}

	}

	public void insert(int data) {
		root = insertNode(root, data);
	}

	public NodeOfTree insertNode(NodeOfTree node, int data) {
		if (node == null) {
			node = new NodeOfTree(data);
			return node;
		}

		if (data <= node.data) {
			node.left = insertNode(node.left, data);
		} else if (data > node.data) {
			node.right = insertNode(node.right, data);
		}

		return node;
	}

	public int searchData(NodeOfTree node, int data) {
		if (node == null) {
			return -1;
		}

		NodeOfTree current = node;

		while (current != null) {
			if (current.data == data) {
				return data;
			}
			if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return -1;
	}

	public NodeOfTree delete(NodeOfTree node, int data) {
		if (node == null) {
			return null;
		}
		if (data == node.data) {

			// There are 3 cases when deleting the node.
			// 1. When there are no children to that node and data is equal
			// to this node, then we can simply set the head to null and
			// return
			if (node.left == null && node.right == null) {
				return null;
			}

			// case 2: If one of the node is null, the send the other node.

			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			// Case 3: when we have both the left child and right child,
			// then we have to find the min from the right sub tree of this
			// node
			// and then shift it to this position and delete that duplicate
			// node.

			int minValue = findMinOfRightsubtree(node.right);
			node.data = minValue;
			node.right = delete(node.right, minValue);
			return node.right;

		} else if (data < node.data) {
			node.left = delete(node.left, data);
			return node.left;
		} else {
			node.right = delete(node.right, data);
			return node.right;
		}
	}

	public int findMinOfRightsubtree(NodeOfTree right) {

		int minValue = right.data;
		NodeOfTree current = right;
		while (current.left != null) {
			minValue = current.data;
			current = current.left;
		}
		return minValue;
	}

	public int findMin(NodeOfTree node) {
		if (node == null) {
			return -1;
		}

		NodeOfTree current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current.data;

	}

	public int findMax(NodeOfTree node) {
		if (node == null) {
			return -1;
		}
		NodeOfTree current = node;
		while (current.right != null) {
			current = current.right;
		}
		return current.data;
	}

	public void preOrderTraversal(NodeOfTree node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public void inOrderTraversal(NodeOfTree node) {
		List<NodeOfTree> list = new ArrayList<NodeOfTree>();
		inOrderTraversal(node, list);
		list.forEach(System.out::print);
	}

	public void inOrderTraversal(NodeOfTree node, List<NodeOfTree> list) {
		if (node == null) {
			return;
		}

		inOrderTraversal(node.left, list);
		list.add(node);
		inOrderTraversal(node.right, list);

	}

	public void postOrderTraversal(NodeOfTree node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.data);
	}

	public void levelOrderTraversal(NodeOfTree node) {
		if (node == null) {
			return;
		}

		Queue<NodeOfTree> queue = new ArrayDeque<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			NodeOfTree current = queue.poll();
			if (current != null) {
				System.out.print(current.data + " ");

				if (current.left != null) {
					queue.offer(current.left);
				}

				if (current.right != null) {
					queue.offer(current.right);
				}
			}
		}

	}

	// For converting a binary tree to BST, we have to perform the following
	// steps
	// 1. Iterate on the given tree using the inorder traversal and create a
	// list.
	// 2. This list will contain the sorted node values.
	// 3. Then sort the elements in the array using Arrays.sort or the merge
	// sort or quick sort
	// 4. Then traverse the same array and insert the data into BST tree

	public void convertBinaryTreeToBST(NodeOfTree node) {
		if (node == null) {
			return;
		}

		List<Integer> list = new ArrayList<>();

		performInorderAndPopulateList(node, list);
		Collections.sort(list);

		Integer[] a = new Integer[list.size()];
		a = list.toArray(a);

		arrayToBST(a, node);
		System.out.println("\nAfter converting the Binary Tree to BST");
		inOrderTraversal(node);
	}

	public static int index = 0;

	public void arrayToBST(Integer[] a, NodeOfTree node) {
		if (node == null) {
			return;
		}

		arrayToBST(a, node.left);
		node.data = a[index];
		index++;
		arrayToBST(a, node.right);

	}

	public void performInorderAndPopulateList(NodeOfTree node, List<Integer> list) {
		if (node == null || list == null) {
			return;
		}
		performInorderAndPopulateList(node.left, list);
		list.add(node.data);
		performInorderAndPopulateList(node.right, list);
	}

	public static void main(String[] args) {
		TreeADT tree = new TreeADT();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print inorder traversal of the BST
		tree.inOrderTraversal(null);
		System.out.println("Searching");
		System.out.println(tree.searchData(tree.root, -50));
		System.out.println("Level order travesal");
		tree.levelOrderTraversal(tree.root);
		System.out.println("Converting the Binary tree to BST");
		NodeOfTree n = new NodeOfTree(10);
		n.left = new NodeOfTree(30);
		n.right = new NodeOfTree(15);
		n.left.left = new NodeOfTree(20);
		n.right.right = new NodeOfTree(5);
		System.out.println("Before converting ");
		tree.inOrderTraversal(n);
		tree.convertBinaryTreeToBST(n);
	}

}
