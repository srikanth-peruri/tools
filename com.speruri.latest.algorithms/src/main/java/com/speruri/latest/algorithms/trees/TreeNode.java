package com.speruri.latest.algorithms.trees;

public class TreeNode<E> {

	TreeNode<E> left;
	E data;
	TreeNode<E> right;

	public TreeNode(E argData) {
		this.data = argData;
	}

	public void insert(E argData) {
		if ((Integer) argData < (Integer) left.data) {
			left.insert(argData);
		} else if ((Integer) argData > (Integer) right.data) {
			right.insert(argData);
		}
		this.data = argData;
	}

	@Override
	public String toString() {
		return "" + this.data;
	}
}
