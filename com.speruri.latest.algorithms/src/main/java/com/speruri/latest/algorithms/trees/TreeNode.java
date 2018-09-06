package com.speruri.latest.algorithms.trees;

public class TreeNode<E> {

	private TreeNode<E> left;
	private E data;
	private TreeNode<E> right;

	public TreeNode(E argData) {
		this.data = argData;
	}


	public void printBST(TreeNode<E> node) {
		if (node == null) {
			return;
		}
		System.out.print(node);
		printBST(node.left);
		printBST(node.right);
	}

	@Override
	public String toString() {
		return this.data + " ";
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

}
