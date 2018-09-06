package com.speruri.latest.algorithms.trees;

import java.awt.HeadlessException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTreeADT<E> {

	TreeNode<Integer> root;

	public BinarySearchTreeADT() {
		this.root = null;
	}

	public void insert(int argData) {
		root = insert(root, argData);
	}

	private TreeNode<Integer> insert(TreeNode<Integer> rootNode, int argData) {
		if (rootNode == null) {
			rootNode = new TreeNode<Integer>(argData);
			return rootNode;
		}

		if (argData < rootNode.getData()) {
			rootNode.setLeft(insert(rootNode.getLeft(), argData));
		} else if (argData > rootNode.getData()) {
			rootNode.setRight(insert(rootNode.getRight(), argData));
		}
		return rootNode;
	}

	public boolean search(int argData) {
		TreeNode<Integer> nodeFound = search(root, argData);
		return (nodeFound != null ? true : false);
	}

	private TreeNode<Integer> search(TreeNode<Integer> argNode, int argData) {
		if (argNode == null || argNode.getData() == argData) {
			return argNode;
		}
		if (argData < argNode.getData()) {
			return search(argNode.getLeft(), argData);
		}
		return search(argNode.getRight(), argData);
	}

	public int findminElement() {
		int min = -1;

		min = findMin(root);

		return min;
	}

	private int findMin(TreeNode<Integer> node) {
		if (node == null) {
			return -1;
		} else if (node.getLeft() == null) {
			return node.getData();
		}
		return findMin(node.getLeft());
	}

	public int findMaximumelement() {
		int result = findMax(root);
		return result;
	}

	private int findMax(TreeNode<Integer> node) {
		if (node == null) {
			return -1;
		} else if (node.getRight() == null) {
			return node.getData();
		}
		return findMax(node.getRight());
	}

	public int heightOfTheTree() {
		return heightOfTree(root);
	}

	private int heightOfTree(TreeNode<Integer> node) {
		if (node == null) {
			return -1;
		}
		int minLeft = heightOfTree(node.getLeft());
		int minRight = heightOfTree(node.getRight());
		int h = Math.max(minLeft, minRight) + 1;
		return h;
	}

	public void performInOrderTraversal() {
		this.inOrderTraversal(root);
	}

	public void inOrderTraversal(TreeNode<Integer> argRoot) {
		if (argRoot == null) {
			return;
		}
		inOrderTraversal(argRoot.getLeft());
		System.out.print(argRoot);
		inOrderTraversal(argRoot.getRight());
	}

	public void performLevelOrderTraversal() {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		TreeNode<E> current;

		while (!queue.isEmpty()) {
			current = queue.poll();
			if (current != null) {
				if (current.getLeft() != null) {
					queue.add(current.getLeft());
				}

				if (current.getRight() != null) {
					queue.add(current.getRight());
				}
				System.out.print(current.getData() + " ");
			}
		}
	}

	public void performPreOrderTraversal() {
		performPreOrderTraversal(root);
	}

	private void performPreOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		System.out.println(node);
		performPreOrderTraversal(node.getLeft());
		performPreOrderTraversal(node.getRight());
	}

	private void performInOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		performPreOrderTraversal(node.getLeft());
		System.out.println(node);
		performPreOrderTraversal(node.getRight());
	}

	private void performPostOrderTraversal(TreeNode<Integer> node) {
		if (node == null)
			return;
		performPreOrderTraversal(node.getLeft());
		performPreOrderTraversal(node.getRight());
		System.out.println(node);
	}

	public void deleteNode(int data) {
		deleteNode(root, data);
	}

	private TreeNode<Integer> deleteNode(TreeNode<Integer> argRootNode, int argData) {
		if (argRootNode == null) {
			return null;
		}

		// Check if the data we are searching is lessthan the root
		if (argData < argRootNode.getData()) {
			argRootNode.setLeft(deleteNode(argRootNode.getLeft(), argData));
		} else if (argData > argRootNode.getData()) {
			argRootNode.setRight(deleteNode(argRootNode.getRight(), argData));
		} else {
			// if the values are same
			// CAse 1 : check whether the left and right child will be null
			if (argRootNode.getLeft() == null && argRootNode.getRight() == null) {
				// Since we are setting the updated node to the root, we need to
				// send some value so that the root gets updated
				return null;
			}
			if (argRootNode.getLeft() == null) {
				return argRootNode.getRight();
			} else if (argRootNode.getRight() == null) {
				return argRootNode.getLeft();
			}

			// Case 3: we have both the left and right child. So, we have to
			// find the min value from right sub tree and then update the root
			// and then delete the duplicate value
			// from which we copied the data

			int minvalue = findMinFromRight(argRootNode.getRight());
			argRootNode.setData(minvalue);
			argRootNode.setRight(deleteNode(argRootNode.getRight(), minvalue));
		}
		return argRootNode;
	}

	private int findMinFromRight(TreeNode<Integer> right) {
		int min = right.getData();
		while (right.getLeft() != null) {
			min = right.getLeft().getData();
			right = right.getLeft();
		}
		return min;
	}

	public boolean isBinarySearchTree(TreeNode<Integer> node) {
		if (node == null) {
			return false;
		}
		boolean valid = false;
		int min = Integer.MIN_VALUE;

		Queue<TreeNode<Integer>> queue = new LinkedBlockingQueue<>();
		queue.add(node);
		TreeNode<Integer> current = node;


		return valid;
	}

	public static void main(String[] args) {
		BinarySearchTreeADT<Integer> tree = new BinarySearchTreeADT<>();
		tree.insert(15);
		tree.insert(12);
		tree.insert(20);

		tree.insert(10);
		tree.insert(14);
		tree.insert(17);
		tree.insert(25);

		tree.insert(5);
		tree.insert(16);
		tree.insert(19);
		tree.insert(22);
		tree.insert(27);

		// tree.performInOrderTraversal();
		// System.out.println();
		// System.out.println(tree.search(100));
		// System.out.println(tree.findminElement());
		// System.out.println(tree.findMaximumelement());
		// System.out.println(tree.heightOfTheTree());
		// System.out.println("Performing BFS");
		System.out.println("Before deleting");
		tree.performInOrderTraversal();
		// tree.deleteNode(5);
		// System.out.println("\nAfter deleting " + 5);
		// tree.performInOrderTraversal();
		tree.deleteNode(20);
		System.out.println("\nAfter deleting " + 20);
		tree.performInOrderTraversal();
	}

}
