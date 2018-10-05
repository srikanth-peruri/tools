package com.speruri.latest.algorithms.practice.graphs;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphOperations {

	public static class Graph {
		int size;
		LinkedList<Integer>[] adjacentListArray;

		public Graph(int size) {
			this.size = size;
			adjacentListArray = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				adjacentListArray[i] = new LinkedList();
			}
		}

	}

	public static void addEdge(Graph g, int src, int dest) {
		if (g == null) {
			return;
		}
		g.adjacentListArray[src].addFirst(dest);
	}

	public static void printGraph(Graph g) {
		if (g == null) {
			return;
		}
		for (int v = 0; v < g.adjacentListArray.length; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : g.adjacentListArray[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public static void performBFS(Graph g, int x) {
		if (g == null && x < 0) {
			return;
		}
		// Put a boolean array
		boolean visited[] = new boolean[g.size];
		// update the visited of that x to true
		visited[x] = true;

		// Queue to add the vertices
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);

		while (!q.isEmpty()) {
			int c = q.poll();
			// sysout the current node;
			System.out.print(c + " ");

			// Iterate on the list
			Iterator<Integer> iterator = g.adjacentListArray[c].listIterator();
			while (iterator.hasNext()) {
				x = iterator.next();
				if (!visited[x]) {
					visited[x] = true;
					q.add(x);
				}
			}
		}
	}

	public static void performDFS(Graph g, int v) {
		boolean visited[] = new boolean[g.size];
		performDFS(g, v, visited);
	}

	public static void performDFS(Graph g, int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> iterator = g.adjacentListArray[v].listIterator();
		while (iterator.hasNext()) {
			int c = iterator.next();
			if (!visited[c]) {
				performDFS(g, c, visited);
			}
		}
	}

	static void BFS(Graph g, int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[g.size];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = g.adjacentListArray[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void performDFSIterative(Graph g, int x) {
		if (g == null) {
			return;
		}

		boolean[] visited = new boolean[g.size];
		Stack<Integer> stack = new Stack<>();
		stack.push(x);

		while (!stack.isEmpty()) {
			int c = stack.pop();
			if (!visited[c]) {
				System.out.print(c + " ");
				visited[c] = true;
			}
			Iterator<Integer> iterator = g.adjacentListArray[c].listIterator();
			while (iterator.hasNext()) {
				int i = iterator.next();
				if (!visited[i]) {
					stack.push(i);
				}
			}
		}

	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		addEdge(graph, 0, 1);
		addEdge(graph, 0, 2);
		addEdge(graph, 1, 2);
		addEdge(graph, 2, 0);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 3);

		// print the adjacency list representation of
		// the above graph
		printGraph(graph);
		System.out.println("BFS");
		performBFS(graph, 2);
		System.out.println("DFS");

		performDFS(graph, 2);
		System.out.println("DFS Iterative");

		performDFSIterative(graph, 2);
	}
}