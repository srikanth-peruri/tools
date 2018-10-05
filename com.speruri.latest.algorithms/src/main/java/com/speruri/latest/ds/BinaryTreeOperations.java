package com.speruri.latest.ds;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeOperations {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data + "";
		}
	}

	public static boolean isBST(TreeNode node) {
		if (node == null) {
			return true;
		}
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(TreeNode node, int minValue, int maxValue) {
		if (node == null) {
			return true;
		}
		// check if the node value falls in range with the min and max
		if (node.data < minValue || node.data > maxValue) {
			return false;
		}
		return isBST(node.left, minValue, node.data - 1) && isBST(node.right, node.data + 1, maxValue);
	}

	public static void performBFS(TreeNode node) {
		if (node == null) {
			return;
		}

		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(node);
		while (!q.isEmpty()) {
			TreeNode c = q.poll();
			System.out.print(c + " ");
			if (c.left != null) {
				q.add(c.left);
			}

			if (c.right != null) {
				q.add(c.right);
			}
		}
	}
	
	public static void performPreOrderTraversal(TreeNode node){
		if(node == null){
			return;
		}
		System.out.print(node + " ");
		performPreOrderTraversal(node.left);
		performPreOrderTraversal(node.right);
	}

	public static void main(String args[]) {
		TreeNode treeNode = new TreeNode(3);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(5);
		treeNode.left.left = new TreeNode(1);
		treeNode.left.right = new TreeNode(4);
		System.out.println("Is BST : " + isBST(treeNode));
		performBFS(treeNode);
		System.out.println("");
		performPreOrderTraversal(treeNode);
	}

}
