package com.speruri.java.ds.algo;

public class GraphTest {
	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);

		graph.addEdge(0, new int[] { 2, 3 });
		graph.addEdge(1, new int[] { 2, 4 });
		graph.addEdge(2, new int[] { 3, 0 });
		graph.addEdge(3, new int[] { 4, 1 });
		graph.addEdge(4, new int[] { 0, 3 });

		graph.printEdges();

	}
}
