package com.speruri.latest.algorithms.practice.graphs;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversals {

	public static class Graph {

		int size;
		private LinkedList<Integer>[] list;

		Graph(int argSize) {
			this.size = argSize;
			list = new LinkedList[size];

			for (int i = 0; i < size; i++) {
				list[i] = new LinkedList();
			}
		}

	}

	public static void addEdge(Graph g, int src, int dest) {
		g.list[src].addFirst(dest);
	}

	public static void printGraph(Graph g) {
		for (int v = 0; v < g.size; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : g.list[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public static void performBFS(Graph g, int start) {
		if (g == null || start < 0) {
			return;
		}

		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[g.size];
		visited[2] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int c = queue.poll();
			System.out.println(c + " ");

			Iterator<Integer> iter = g.list[c].listIterator();
			while (iter.hasNext()) {
				int current = iter.next();
				if (!visited[current]) {
					queue.add(current);
					visited[current] = true;
				}
			}
		}
	}

	public static void performDFS(Graph g, int s) {
		boolean[] visited = new boolean[g.size];
		performDFS(g, visited, s);
	}

	public static void performDFS(Graph g, boolean[] visited, int s) {
		if (g == null || s < 0) {
			return;
		}
		visited[s] = true;
		System.out.print(s + " ");
		Iterator<Integer> iter = g.list[s].listIterator();
		while (iter.hasNext()) {
			int current = iter.next();
			if (!visited[current]) {
				performDFS(g, visited, current);
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		addEdge(g, 0, 1);
		addEdge(g, 0, 2);
		addEdge(g, 1, 2);
		addEdge(g, 2, 0);
		addEdge(g, 2, 3);
		addEdge(g, 3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		performBFS(g, 2);
		System.out.println("DFS");
		performDFS(g, 2);
	}
}
