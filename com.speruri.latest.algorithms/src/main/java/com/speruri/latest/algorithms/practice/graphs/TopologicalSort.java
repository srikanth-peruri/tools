package com.speruri.latest.algorithms.practice.graphs;

import java.util.Iterator;
import java.util.Stack;

import com.speruri.latest.algorithms.practice.graphs.GraphOperations.Graph;

public class TopologicalSort {

	public static void topologicalSortUtil(Graph g, int x, boolean[] visited, Stack stack) {
		visited[x] = true;
		Iterator<Integer> iterator = g.adjacentListArray[x].listIterator();
		while (iterator.hasNext()) {
			int c = iterator.next();
			if (!visited[c]) {
				topologicalSortUtil(g, c, visited, stack);
			}
		}
		stack.push(x);
	}

	public static void topologicalSort(Graph g) {
		boolean visited[] = new boolean[g.size];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < g.size; i++) {
			if (!visited[i]) {
				topologicalSortUtil(g, i, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		GraphOperations.addEdge(g, 5, 2);
		GraphOperations.addEdge(g, 5, 0);
		GraphOperations.addEdge(g, 4, 0);
		GraphOperations.addEdge(g, 4, 1);
		GraphOperations.addEdge(g, 2, 3);
		GraphOperations.addEdge(g, 3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		topologicalSort(g);
	}

}
