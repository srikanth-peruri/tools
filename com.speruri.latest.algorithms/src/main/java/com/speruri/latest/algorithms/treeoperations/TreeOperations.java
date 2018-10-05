package com.speruri.latest.algorithms.treeoperations;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class TreeOperations {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int argData) {
			this.data = argData;
		}

		@Override
		public String toString() {
			return this.data + " ";
		}
	}

	public static void insert(TreeNode root, int data) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> q = new ArrayDeque<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode c = q.poll();
			if (c.left == null) {
				c.left = new TreeNode(data);
				break;
			} else {
				q.add(c.left);
			}

			if (c.right == null) {
				c.right = new TreeNode(data);
				break;
			} else {
				q.add(c.right);
			}
		}
	}

	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root);
		inorderTraversal(root.right);
	}

	public static class DLLNode {
		int data;
		DLLNode prev;
		DLLNode next;

		public DLLNode(int argData) {
			this.data = argData;
		}

		@Override
		public java.lang.String toString() {
			return this.data + " ";
		}
	}

	public static void createInOnOrderList(TreeNode root) {
		if (root == null) {
			return;
		}
		List<Integer> list = new java.util.ArrayList();
		createInOnOrderList(root, list);
		DLLNode dllRoot = createDllWithList(list, null);
		printDll(dllRoot);
	}

	private static void printDll(DLLNode dllRoot) {
		DLLNode current = dllRoot;
		while (current != null) {
			System.out.print(current);
			current = current.next;
		}
	}

	private static DLLNode createDllWithList(List<Integer> list, DLLNode object) {
		DLLNode root = new DLLNode(list.get(0));
		DLLNode current = root;
		for (int i = 1; i < list.size(); i++) {
			DLLNode newNode = new DLLNode(list.get(i));
			current.next = newNode;
			newNode.prev = current;
			current = newNode;
		}
		return root;
	}

	public static void createInOnOrderList(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		createInOnOrderList(root.left, list);
		list.add(root.data);
		createInOnOrderList(root.right, list);
	}

	public static void printOddNodes(TreeNode root) {
		printOddLevelNodes(root, true);
	}

	public static void printOddLevelNodes(TreeNode root, boolean isOdd) {
		if (root == null) {
			return;
		}
		if (isOdd) {
			System.out.print(root);
		}
		printOddLevelNodes(root.left, !isOdd);
		printOddLevelNodes(root.right, !isOdd);
	}

	public static boolean isBST(TreeNode node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}
		boolean isLeftBST = isBST(node.left, min, node.data - 1);
		boolean isRightBST = isBST(node.right, node.data + 1, max);
		return isLeftBST && isRightBST;
	}

	public static int elementThatAppearsOnce(int[] ar) {
		if (ar == null || ar.length == 0) {
			return -1;
		}

		int res = ar[0];
		for (int i = 1; i < ar.length; i++)
			res = res ^ ar[i];

		return res;
	}

	public static char findExtraChar(String strA, String strB) {

		int res = 0;

		for (int i = 0; i < strA.length(); i++) {
			res = res ^ strA.charAt(i);
		}

		for (int i = 0; i < strB.length(); i++) {
			res = res ^ strB.charAt(i);
		}

		return (char) res;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(11);
		root.left.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(8);

		System.out.print("\nInorder traversal before insertion:");
		inorderTraversal(root);

		int key = 12;
		insert(root, key);
		System.out.print("\nInorder traversal after insertion:");
		inorderTraversal(root);
		System.out.println();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		r.left.left = new TreeNode(4);
		r.left.right = new TreeNode(5);
		printOddNodes(r);

		System.out.println("BT to DLL");
		TreeNode dll = new TreeNode(10);
		dll.left = new TreeNode(12);
		dll.right = new TreeNode(15);
		dll.left.left = new TreeNode(25);
		dll.left.right = new TreeNode(30);
		dll.right.left = new TreeNode(36);
		createInOnOrderList(dll);

		root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(-10000);
		root.left.right = new TreeNode(3);
		System.out.println("Is BST : " + isBST(root));

		int ar[] = { 2, 3, 5, 4, 5, 4 };
		System.out.println("Element occurring once is " + elementThatAppearsOnce(ar) + " ");
		System.out.println((int) 'z');
		System.out.println(127 & 225);

		System.out.println("SExtra char :" + findExtraChar("abcd", "cbiad"));
	}

}
