package com.speruri.latest.algorithms.practice;

import java.util.List;
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

	public static boolean areMirrorTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}

		if (t1 == null || t2 == null) {
			return false;
		}

		boolean isMirror = (t1.data == t2.data);

		return isMirror && areMirrorTree(t1.left, t2.right) && areMirrorTree(t1.right, t2.left);
	}

	public static boolean isBSTTree(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if ((Integer) root.data <= min || (Integer) root.data > max) {
			return false;
		}

		return isBSTTree(root.left, min, (Integer) root.data) && isBSTTree(root.right, (Integer) root.data, max);

	}

	public TreeNode findLCA(TreeNode root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		TreeNode leftLCA = findLCA(root.left, n1, n2);
		TreeNode rightLCA = findLCA(root.right, n1, n2);
		if (leftLCA != null && rightLCA != null) {
			return root;
		}
		return (leftLCA != null ? leftLCA : rightLCA);
	}

	public static boolean roottoLeafSum(TreeNode root, int sum, List<TreeNode> list) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			if (root.data.equals(sum)) {
				list.add(root);
				return true;
			} else {
				return false;
			}
		}
		// if(roottoLeafSum(root.left, sum - root.data,list)){
		// list.add(root);
		// return true;
		// }
		//
		//

		return false;

	}

	public static int size(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftSize = size(node.left);
		int rightSize = size(node.right);
		return leftSize + rightSize + 1;
	}

	public int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static boolean areSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}

		boolean same = areSameTree(t1, t2);

		return same && areSameTree(t1.left, t2.left) && areSameTree(t1.right, t2.right);

	}

	public static boolean areMirror(TreeNode<Integer> tree1, TreeNode<Integer> tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}

		if (tree1 == null || tree2 == null) {
			return false;
		}

		return (tree1.data == tree2.data) && areMirror(tree1.left, tree2.right) && areMirror(tree1.right, tree2.left);

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

		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		a.left.left = new TreeNode(4);
		a.left.right = new TreeNode(5);

		b.left = new TreeNode(3);
		b.right = new TreeNode(2);
		b.right.left = new TreeNode(5);
		b.right.right = new TreeNode(4);

		System.out.println("Are trees? " + areMirror(a, b));
		System.out.println("Are trees? " + areMirrorTree(a, b));

	}
}
