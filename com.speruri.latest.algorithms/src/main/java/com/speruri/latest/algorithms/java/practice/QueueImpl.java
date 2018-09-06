package com.speruri.latest.algorithms.java.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImpl {

	private Comparator<Product> comparator = new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			int result = 0;
			if (p1.getWeight() == p2.getWeight()) {
				result = 0;
			} else if (p1.getWeight() < p2.getWeight()) {
				result = 1;
			} else {
				result = -1;
			}
			return result;
		}
	};

	private Comparator<Product> compCategory = new Comparator<Product>() {

		@Override
		public int compare(Product p1, Product p2) {
			return -1;// Integer.compare(p1.getCategory(), p2.getCategory());
		}

	};

	private Queue<Product> queue = new PriorityQueue<>(comparator);

	public void addProduct(Product product) {
		this.queue.offer(product);
	}

	public void displayProducts() {
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	public static void main(String[] args) {
		QueueImpl q = new QueueImpl();
		Product window = new Product("Window", 10);
		Product door = new Product("Wooden Door", 35);
		Product floorPanel = new Product("Floor Panel", 25);

		q.addProduct(door);
		q.addProduct(floorPanel);
		q.addProduct(window);

		q.displayProducts();
	}

}
