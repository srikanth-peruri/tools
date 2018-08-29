package com.speruri.latest.algorithms.trees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreePractice<E> {

	public void preOrderDFSTraversalWithRecursion(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		System.out.print(node);
		preOrderDFSTraversalWithRecursion(node.getLeft());
		preOrderDFSTraversalWithRecursion(node.getRight());
	}

	public void inOrderDFSTraversalWithRecursion(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		inOrderDFSTraversalWithRecursion(node.getLeft());
		System.out.print(node);
		inOrderDFSTraversalWithRecursion(node.getRight());
	}

	public void postOrderDFSTraversalWithRecursion(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		postOrderDFSTraversalWithRecursion(node.getLeft());
		postOrderDFSTraversalWithRecursion(node.getRight());
		System.out.print(node);
	}

	public void preOrderTraversalWithoutRecursionAndWithStack(TreeNode<E> node) {
		if (node == null) {
			return;
		}

		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		stack.push(node);
		TreeNode<E> current;

		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current);
			if (current.getRight() != null) {
				stack.push(current.getRight());
			}

			if (current.getLeft() != null) {
				stack.push(current.getLeft());
			}
		}

	}

	public void inOrderTraversalWithoutRecursionAndWithStack(TreeNode<E> node) {
		if (node == null) {
			return;
		}

		boolean done = false;

		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		TreeNode<E> current = node;
		while (!done) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					System.out.print(current);
					current = current.getRight();
				} else {
					done = true;
				}
			}
		}

	}

	// public void postOrderTraversalWithoutRecursionAndWithStack(TreeNode<E>
	// node) {
	// if (node == null) {
	// return;
	// }
	// // 1
	// // 2 3
	// // 4 5 6 7
	// //
	// //
	//
	// Stack<TreeNode<E>> stack = new Stack();
	//
	// TreeNode<E> current = node;
	//
	// boolean done = false;
	//
	// while (!done) {
	// if (current != null) {
	// stack.push(current);
	// current = current.getLeft();
	// } else {
	// if (!stack.isEmpty()) {
	// current = stack.pop();
	// System.out.print(current);
	// current = current.getRight();
	// } else {
	// done = true;
	//
	// }
	// }
	// }
	//
	// }

	public void insertIntoTree(TreeNode<E> root, TreeNode<E> newNode) {
		if (root == null) {
			return;
		}

		Queue<TreeNode<E>> queue = new LinkedBlockingQueue();
		queue.add(root);

		TreeNode<E> current;

		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			} else {
				current.setLeft(newNode);
				break;
			}

			if (current.getRight() != null) {
				queue.add(current.getRight());
			} else {
				current.setRight(newNode);
				break;
			}
		}
		inOrderDFSTraversalWithRecursion(root);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<Integer>(3));

		root.getLeft().setLeft(new TreeNode<Integer>(4));
		root.getLeft().setRight(new TreeNode<Integer>(5));

		root.getRight().setLeft(new TreeNode<Integer>(6));
		root.getRight().setRight(new TreeNode<Integer>(7));

		BinaryTreePractice<Integer> binaryTree = new BinaryTreePractice<Integer>();

		System.out.println("Pre order traversal with recursion");
		binaryTree.preOrderDFSTraversalWithRecursion(root);
		System.out.println();

		System.out.println("In order traversal with recursion");
		binaryTree.inOrderDFSTraversalWithRecursion(root);
		System.out.println();

		System.out.println("post order traversal with recursion");
		binaryTree.postOrderDFSTraversalWithRecursion(root);
		System.out.println();

		System.out.println("pre order traversal without recursion with stack");
		binaryTree.preOrderTraversalWithoutRecursionAndWithStack(root);
		System.out.println();

		System.out.println("in order traversal without recursion with stack");
		binaryTree.inOrderTraversalWithoutRecursionAndWithStack(root);
		System.out.println();

		// System.out.println("post order traversal without recursion with
		// stack");
		// binaryTree.postOrderTraversalWithoutRecursionAndWithStack(root);
		// System.out.println();

		System.out.println("in order traversal without recursion with stack");
		binaryTree.insertIntoTree(root, new TreeNode<Integer>(9));
		System.out.println();

	}
}
