package com.speruri.latest.algorithms.practice;

import java.util.Stack;

public class TreeOperations {

	public static class TreeNode<E> {
		E data;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E argData) {
			this.data = argData;
			left = null;
			right = null;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public TreeNode<E> getLeft() {
			return left;
		}

		public void setLeft(TreeNode<E> left) {
			this.left = left;
		}

		public TreeNode<E> getRight() {
			return right;
		}

		public void setRight(TreeNode<E> right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}

	}

	public static boolean isBinaryTree(TreeNode<Integer> node) {
		if (node == null) {
			return false;
		}

		boolean valid = false;
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();

		stack.push(node);
		boolean done = false;
		TreeNode<Integer> current;

		while (!done) {
			current = stack.pop();
			System.out.print(current);
			if (current != null) {
				stack.push(current.getLeft());
			} else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					stack.push(current.getRight());
				} else {
					done = true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		TreeNode<Integer> head = new TreeNode<Integer>(15);
		TreeNode<Integer> node1 = new TreeNode<Integer>(10);
		TreeNode<Integer> node2 = new TreeNode<Integer>(18);
		TreeNode<Integer> node3 = new TreeNode<Integer>(8);
		TreeNode<Integer> node4 = new TreeNode<Integer>(13);
		TreeNode<Integer> node5 = new TreeNode<Integer>(17);
		TreeNode<Integer> node6 = new TreeNode<Integer>(20);

		head.setLeft(node1);
		node1.setLeft(node3);
		node1.setRight(node4);

		head.setRight(node2);
		node2.setLeft(node5);
		node2.setRight(node6);
		isBinaryTree(head);
	}
}
