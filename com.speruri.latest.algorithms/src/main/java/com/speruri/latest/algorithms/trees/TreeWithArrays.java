package com.speruri.latest.algorithms.trees;

public class TreeWithArrays {

	private Integer[] array;

	private int root = 0;

	public TreeWithArrays() {
		this.array = new Integer[10];
	}

	public void setRoot(Integer argRoot) {
		this.array[0] = argRoot;
	}

	public void setLeft(Integer argData, int index) {
		int leftIndex = (2 * index) + 1;
		if (this.array[index] == null) {
			System.err.println("No parent found at " + index);
		} else {
			this.array[leftIndex] = argData;
		}
	}

	public void setRight(Integer argData, int index) {
		int rightIndex = (2 * index) + 2;
		if (this.array[index] == null) {
			System.err.println("No parent found at " + index);
		} else {
			this.array[rightIndex] = argData;
		}
	}

	public void displayArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(this.array[i] + " ");
		}
	}

	public static void main(String[] args) {
		TreeWithArrays tree = new TreeWithArrays();
		tree.setRoot(1);
		tree.setLeft(2, 0);
		tree.setRight(3, 0);
		tree.setLeft(4, 1);
		tree.setRight(5, 1);
		tree.displayArray();
	}

}
