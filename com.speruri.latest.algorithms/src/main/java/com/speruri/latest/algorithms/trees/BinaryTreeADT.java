package com.speruri.latest.algorithms.trees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTreeADT<E> {

	private TreeNode<E> root;

	public void printPreOrderDFSTraversal(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		// In pre-Order traversal, we first vist the
		// root -> left -> right

		System.out.print(node.getData() + " ");
		printPreOrderDFSTraversal(node.getLeft());
		printPreOrderDFSTraversal(node.getRight());
	}

	public void printInOrderDFSTraversal(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		// In pre, we traverse the left node, then root and then right mode
		printInOrderDFSTraversal(node.getLeft());
		System.out.print(node.getData() + " ");
		printInOrderDFSTraversal(node.getRight());
	}

	public void printPostOrderDFSTraversal(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		printPostOrderDFSTraversal(node.getLeft());
		printPostOrderDFSTraversal(node.getRight());
		System.out.print(node.getData() + " ");
	}

	public void printInOrderTraversalWithoutRecursion(TreeNode<E> root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

		TreeNode<E> current = root;

		boolean done = false;

		while (!done) {

			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				if (!stack.isEmpty()) {
					current = stack.pop();
					System.out.print(current.getData() + " ");
					current = current.getRight();
				} else {
					done = true;
				}
			}

		}

	}

	public void reverseLevelOrder(TreeNode<E> node, Queue<TreeNode<E>> queue, Stack<TreeNode<E>> stack) {
		if (node == null) {
			return;
		}
		if (node.getRight() != null) {
			queue.add(node.getRight());
		}
		if (node.getLeft() != null) {
			queue.add(node.getLeft());
		}
		stack.push(node);
		reverseLevelOrder(queue.poll(), queue, stack);
	}

	public void printBFSTraversal(TreeNode<E> node, Queue<TreeNode<E>> queue) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		if (node.getLeft() != null) {
			queue.add(node.getLeft());
		}
		if (node.getRight() != null) {
			queue.add(node.getRight());
		}
		printBFSTraversal(queue.poll(), queue);
	}

	public int findHalfNodes(TreeNode<Integer> numRoot) {
		int count = 0;
		if (numRoot == null) {
			return 0;
		}

		if ((numRoot.getLeft() != null && numRoot.getRight() == null)
				|| (numRoot.getLeft() == null && numRoot.getRight() != null)) {
			count = count + 1;
		}
		count += findHalfNodes(numRoot.getLeft());
		count += findHalfNodes(numRoot.getRight());
		return count;
	}

	public int countLeafNodesWithStack(TreeNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		int count = 0;

		boolean done = false;
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();

		while (!done) {
			if (node != null) {
				if (node.getLeft() == null && node.getRight() == null) {
					count++;
				}
				stack.push(node);
				node = node.getLeft();
			} else {
				if (!stack.isEmpty()) {
					node = stack.pop().getRight();
				} else {
					done = true;
				}
			}
		}
		return count;
	}

	public int countLeafNodesWithQueue(TreeNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		int count = 0;
		Queue<TreeNode<Integer>> queue = new LinkedBlockingQueue<TreeNode<Integer>>();
		queue.add(node);
		TreeNode<Integer> current = null;
		while (!queue.isEmpty()) {
			current = queue.poll();

			if (current.getLeft() != null) {
				queue.add(current.getLeft());
			}
			if (current.getRight() != null) {
				queue.add(current.getRight());
			}
			if (current.getLeft() == null && current.getRight() == null) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<String>("A");
		root.setLeft(new TreeNode<String>("B"));
		root.setRight(new TreeNode<String>("C"));

		root.getLeft().setLeft(new TreeNode<String>("D"));
		root.getLeft().setRight(new TreeNode<String>("E"));

		root.getLeft().getRight().setLeft(new TreeNode<String>("F"));

		Queue<TreeNode<String>> queue = new ArrayBlockingQueue<TreeNode<String>>(10);

		System.out.println("========BFS START=============");
		BinaryTreeADT<String> binaryTreeADT = new BinaryTreeADT<String>();
		binaryTreeADT.printBFSTraversal(root, queue);
		System.out.println("========BFS END=============");

		System.out.println("========Pre Order START=============");
		binaryTreeADT.printPreOrderDFSTraversal(root);
		System.out.println();
		System.out.println("========Pre Order End=============");

		System.out.println("========In Order START=============");
		binaryTreeADT.printInOrderDFSTraversal(root);
		System.out.println();
		System.out.println("========In Order End=============");

		System.out.println("========In Order START NON recursive=============");
		binaryTreeADT.printInOrderTraversalWithoutRecursion(root);
		System.out.println();
		System.out.println("========In Order End NON recursive=============");

		System.out.println("========Post Order START=============");
		binaryTreeADT.printPostOrderDFSTraversal(root);
		System.out.println();
		System.out.println("========Post Order End=============");

		System.out.println("========Reverse Level Order START=============");
		queue.clear();
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
		binaryTreeADT.reverseLevelOrder(root, queue, stack);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getData() + " ");
		}
		System.out.println();
		System.out.println("========Reverse Level Order End=============");

		TreeNode<Integer> numRoot = new TreeNode<Integer>(2);
		numRoot.setLeft(new TreeNode<Integer>(7));
		numRoot.setRight(new TreeNode<Integer>(5));

		numRoot.getLeft().setRight(new TreeNode<Integer>(6));

		numRoot.getLeft().getRight().setLeft(new TreeNode<Integer>(1));
		numRoot.getLeft().getRight().setRight(new TreeNode<Integer>(11));

		numRoot.getRight().setRight(new TreeNode<Integer>(9));
		numRoot.getRight().getRight().setLeft(new TreeNode<Integer>(4));

		System.out.println("========count half nodes START=============");
		System.out.println(binaryTreeADT.findHalfNodes(numRoot));
		System.out.println("========Count half nodes End=============");

		System.out.println("========count leaf nodes with Stack START=============");
		System.out.println(binaryTreeADT.countLeafNodesWithStack(numRoot));
		System.out.println("========Count leaf nodes Stack End=============");

		System.out.println("========count leaf nodes with Queue START=============");
		System.out.println(binaryTreeADT.countLeafNodesWithQueue(numRoot));
		System.out.println("========Count leaf nodes Queue End=============");

	}

}
