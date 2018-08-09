package com.speruri.java.ds.algo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int vertexIndex;
	private List<Node> nodeList;

	public Vertex(int argIndex) {
		vertexIndex = argIndex;
		nodeList = new ArrayList<Node>();
	}

	public void addEdges(int[] argNodes) {
		Node headNode = null;
		for (int i = 0; i < argNodes.length; i++) {
			int nodeIndex = argNodes[i];
			Node<Integer> newNode = new Node<Integer>(nodeIndex);
			newNode.setNext(headNode);
			headNode = newNode;
			this.nodeList.add(newNode);
		}
	}

	public int getVertexIndex() {
		return this.vertexIndex;
	}

	public void setVertexIndex(int argVertexIndex) {
		this.vertexIndex = argVertexIndex;
	}

	public List<Node> getNodeList() {
		return this.nodeList;
	}

	public void setNodeList(List<Node> argNodeList) {
		this.nodeList = argNodeList;
	}

}
