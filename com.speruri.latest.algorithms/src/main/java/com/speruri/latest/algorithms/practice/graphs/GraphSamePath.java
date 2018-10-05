package com.speruri.latest.algorithms.practice.graphs;

import java.util.Iterator;

import com.speruri.latest.algorithms.practice.graphs.GraphOperations.Graph;
import com.speruri.latest.algorithms.practice.graphs.GraphOperations.Graph;

public class GraphSamePath {

	public static int MAX = 10000;

	int[] intime = new int[MAX];
	int[] outtime = new int[MAX];
	boolean[] visited = new boolean[MAX];
	int timer = 0;

	public void isSamePath(Graph g, int x) {
		if (g == null) {
			return;
		}
		// Update the visited status
		visited[x] = true;
		// update the intime of this node
		intime[x] = ++timer;

		// Iterate on all the adjacent nodes
		Iterator<Integer> iterator = g.adjacentListArray[x].iterator();
		while (iterator.hasNext()) {
			int c = iterator.next();
			if (!visited[c]) {
				isSamePath(g, c);
			}
		}
		// update the outtime of this node
		outtime[x] = ++timer;
	}

	public boolean isOnSamePath(int x, int y) {
		boolean samPath = false;
		samPath = (intime[x] < intime[y] && outtime[x] > outtime[y])
				|| (intime[y] < intime[x] && outtime[y] > outtime[x]);
		return samPath;
	}

	public static void main(String[] args) {
		int n = 10; // total number of nodes
		Graph g = new Graph(n);
		GraphOperations.addEdge(g, 1, 2);

		GraphOperations.addEdge(g, 1, 2);
		GraphOperations.addEdge(g, 1, 3);
		GraphOperations.addEdge(g, 3, 6);
		GraphOperations.addEdge(g, 2, 4);
		GraphOperations.addEdge(g, 2, 5);
		GraphOperations.addEdge(g, 5, 6);
		GraphOperations.addEdge(g, 5, 8);
		GraphOperations.addEdge(g, 5, 9);

		// Start dfs (here root node is 1)
		GraphSamePath gsame = new GraphSamePath();
		gsame.isSamePath(g, 1);
		// below are calls for few pairs of nodes
		System.out.println(gsame.isOnSamePath(1, 5));
		System.out.println(gsame.isOnSamePath(2, 9));
		System.out.println(gsame.isOnSamePath(2, 6));
	}

}
