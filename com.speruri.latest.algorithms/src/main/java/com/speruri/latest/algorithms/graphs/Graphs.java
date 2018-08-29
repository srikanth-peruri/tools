package com.speruri.latest.algorithms.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Graphs {

	private int size;
	private LinkedList<Integer>[] list;

	public Graphs(int size) {
		this.size = size;
		this.list = new LinkedList[size];
		for (int i = 0; i < list.length; i++) {
			this.list[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		this.list[src].add(dest);
	}

	public void displayEdges() {
		if (this.list != null && this.list.length > 0) {
			for (int j = 0; j < list.length; j++) {
				System.out.println("Edges for : " + j);
				Iterator<Integer> iterator = this.list[j].iterator();
				if (iterator != null) {
					while (iterator.hasNext()) {
						Integer next = iterator.next();
						System.out.print(next + " ");
					}
				}
				System.out.println();
			}
		}
	}

	public void performBreadthfirstsearch(int nodeIndex) {
		Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
		queue.add(nodeIndex);

		boolean[] visited = new boolean[size];
		visited[nodeIndex] = true;

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			System.out.print(currentNode + " ");
			Iterator<Integer> iterator = this.list[currentNode].listIterator();
			while (iterator.hasNext()) {
				int node = iterator.next();
				if (!visited[node]) {
					visited[node] = true;
					queue.add(node);
				}
			}
		}
	}

	public void performDepthfirstsearch(int nodeIndex) {
		performDepthfirstsearch(nodeIndex, new boolean[size]);
	}

	public void performDepthfirstsearch(int nodeIndex, boolean[] visited) {
		visited[nodeIndex] = true;
		System.out.print(nodeIndex + " ");

		Iterator<Integer> iterator = this.list[nodeIndex].listIterator();
		while (iterator.hasNext()) {
			int cNode = iterator.next();
			if (!visited[cNode]) {
				performDepthfirstsearch(cNode, visited);
			}
		}
	}

	public static void main(String[] args) {
		Graphs g = new Graphs(4);
		g.addEdge(0, 1);// 0 -> 1, 2
		g.addEdge(0, 2);//
		g.addEdge(1, 2);// 1 -> 0, 2
		g.addEdge(2, 0);// 2 -> 0, 1, 3
		g.addEdge(2, 3);
		g.addEdge(3, 3);// 3 -> 2, 3, 0

		g.displayEdges();
		System.out.println("performing BFS");
		g.performBreadthfirstsearch(2);
		System.out.println();
		System.out.println("performing DFS");
		g.performDepthfirstsearch(2);
	}

}
