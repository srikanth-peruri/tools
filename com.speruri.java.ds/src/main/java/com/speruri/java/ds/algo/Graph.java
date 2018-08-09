package com.speruri.java.ds.algo;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Vertex> vertices;

	public Graph() {
		this.vertices = new ArrayList<Vertex>();
	}

	public Vertex addVertex(int argIndex) {
		Vertex vertex = new Vertex(argIndex);
		this.vertices.add(vertex);
		return vertex;
	}

	public void addEdge(int argVertexIndex, int[] argEdges) {
		Vertex vertex = this.vertices.get(argVertexIndex);
		if (vertex == null) {
			vertex = this.addVertex(argVertexIndex);
		}
		vertex.addEdges(argEdges);
	}

	public void printEdges() {
		if (this.vertices != null && this.vertices.size() > 0) {
			for (Vertex vertex : vertices) {
				System.out.print(vertex.getVertexIndex() + "--->");
				List<Node> nodeList = vertex.getNodeList();
				if (nodeList != null && nodeList.size() > 0) {
					for (int i = 0; i < nodeList.size(); i++) {
						Node node = nodeList.get(i);
						while (node != null && node.getNext() != null) {
							System.out.print(node.getData());
							if (i < nodeList.size()) {
								System.out.print("--->");
							}
							node = node.getNext();
						}
					}
				}
				System.out.println();
			}
		}
	}

}
