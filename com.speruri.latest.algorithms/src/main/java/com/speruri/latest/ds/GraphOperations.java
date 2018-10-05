package com.speruri.latest.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class GraphOperations {

	public static class Graph {
		int size;
		LinkedList<Integer>[] adjacentList;

		public Graph(int size) {
			this.size = size;
			adjacentList = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				adjacentList[i] = new LinkedList<Integer>();
			}
		}

	}

	public static void addEdge(Graph g, int src, int dest) {
		g.adjacentList[src].addFirst(dest);
	}

	public static void printGraph(Graph g) {
		if (g == null) {
			return;
		}

		for (int v = 0; v < g.size; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : g.adjacentList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public static void printAllPaths(Integer src, Integer dest, Graph g, boolean[] visited,
			List<Integer> localPathList) {
		if (g == null || localPathList == null || src < 0 || dest < 0) {
			return;
		}
		// update the visited of src to true
		visited[src] = true;
		// check if we reached the destination. If yes, then display the local
		// path list
		if (src.equals(dest)) {
			System.out.println(localPathList);
		}
		// now iterate on the adjacent list of the current node.
		Iterator<Integer> i = g.adjacentList[src].iterator();
		while (i.hasNext()) {
			Integer current = i.next();
			// if not visited
			if (!visited[current]) {
				// then add it to the local path list
				localPathList.add(current);
				// traverse to other node
				printAllPaths(current, dest, g, visited, localPathList);

				// remove the node from the local path list
				localPathList.remove(current);
			}
		}
		// update the src
		visited[src] = false;
	}

	public static void printAllPathBetweenSrcToDest(Integer src, Integer dest, Graph g, boolean[] visited,
			List<Integer> localPathList) {
		if (g == null || src < 0 || dest < 0 || visited == null || localPathList == null) {
			return;
		}

		// Update the visited array for this src
		visited[src] = true;

		// check whether we received the dest
		if (src.equals(dest)) {
			System.out.println(localPathList);
		}

		// get the adjacent nodes of this src node and then traverse if not
		// visited yet
		Iterator<Integer> iter = g.adjacentList[src].iterator();
		while (iter.hasNext()) {
			Integer current = iter.next();
			// if not the current adjacent node is visited, then traverse that
			// node.
			if (!visited[current]) {
				// add that to the local path list
				localPathList.add(current);
				// now go to the next adjacent node
				printAllPathBetweenSrcToDest(current, dest, g, visited, localPathList);
				// Now remove the node from the localpath list since we are done
				// with the traversing
				localPathList.remove(current);
			}
		}
		// since this is a recursion, we should also update the visited of this
		// src to false to explore the other possibilities as well
		visited[src] = false;

	}

	public static void performBFS(Graph g, int x) {
		if (g == null) {
			return;
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		// firest add the iterm to the queue
		queue.add(x);
		// keep track of all the nodes iterated to avoid recursion
		boolean[] visited = new boolean[g.size];
		// update the current node
		visited[x] = true;
		while (!queue.isEmpty()) {
			int c = queue.poll();
			System.out.print(c + " ");

			// Now iterate on the adjacent nodes of c
			ListIterator<Integer> listIterator = g.adjacentList[c].listIterator();
			// now iterate on the list iterate and add the next node to the
			// queue
			while (listIterator.hasNext()) {
				int current = listIterator.next();
				// check whether this is visited or not
				if (!visited[current]) {
					// update the visited boolean
					visited[current] = true;
					// add it to the queue
					queue.add(current);
				}
			}
		}
	}

	public static void performDFS(Graph g, int x) {
		performDFS(g, x, new boolean[g.size]);
	}

	public static void performDFS(Graph g, int x, boolean[] visited) {
		if (g == null || x < 0) {
			return;
		}
		// first update the visited to true
		visited[x] = true;
		// print the node value
		System.out.print(x + " ");

		// get the iterator for that linked list and iterate on that
		Iterator<Integer> iterator = g.adjacentList[x].iterator();
		while (iterator.hasNext()) {
			int current = iterator.next();
			if (!visited[current]) {
				performDFS(g, current, visited);
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
		System.out.println("Printing graph");
		printGraph(graph);
		System.out.println("Performing BFS");
		performBFS(graph, 2);
		System.out.println("\nPerforming DFS");
		performDFS(graph, 2);

		Graph g = new Graph(4);
		addEdge(g, 0, 1);
		addEdge(g, 0, 2);
		addEdge(g, 0, 3);
		addEdge(g, 2, 0);
		addEdge(g, 2, 1);
		addEdge(g, 1, 3);

		// arbitrary source
		int s = 2;

		// arbitrary destination
		int d = 3;

		System.out.println("Following are all different paths from " + s + " to " + d);
		printAllPathBetweenSrcToDest(s, d, g, new boolean[g.size], new ArrayList());

	}

}
