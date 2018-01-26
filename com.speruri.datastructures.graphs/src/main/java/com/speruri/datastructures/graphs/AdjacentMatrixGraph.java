package com.speruri.datastructures.graphs;

import java.util.List;

import javax.management.RuntimeErrorException;

public class AdjacentMatrixGraph implements Graph {

	private int[][] adjacentGraph;
	private int noOfVertices;
	private GraphType graphType = GraphType.DIRECTED;

	public AdjacentMatrixGraph(int argNoOfVertices, GraphType argGraphType) {
		this.noOfVertices = argNoOfVertices;
		this.graphType = argGraphType;

		this.adjacentGraph = new int[argNoOfVertices][argNoOfVertices];

		for (int i = 0; i < this.noOfVertices; i++) {
			for (int j = 0; i < this.noOfVertices; i++) {
				this.adjacentGraph[i][j] = 0;
			}
		}

	}

	public void addEdge(int v1, int v2) {
		if (v1 < 0 || v2 < 0 || v1 >= noOfVertices || v2 >= noOfVertices) {
			throw new RuntimeException();
		}

		this.adjacentGraph[v1][v2] = 1;
		if (this.graphType == GraphType.UNDIRECTED) {
			this.adjacentGraph[v1][v2] = 1;
		}
	}

	public List<Integer> getAdjacentVertices(int v) {

		if (v < 0 || v >= noOfVertices) {
			throw new RuntimeException("Tirrata");
		}
		
		
		

		return null;

	}

}
