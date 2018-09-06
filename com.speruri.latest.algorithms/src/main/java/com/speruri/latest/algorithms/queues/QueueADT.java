package com.speruri.latest.algorithms.queues;

public class QueueADT {

	private int[] array;
	private int front = -1;
	private int rear = -1;

	public QueueADT(int size) {
		this.array = new int[size];
	}

	public void enqueue(int data) {
		if (this.array.length == 0) {
			front++;
		}
		this.array[++rear] = data;
	}

	public boolean isFull() {
		return front == this.array.length - 1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public int dequeue() {
		if (this.array.length == 0) {
			throw new RuntimeException("Queue is empty");
		}
		int temp = this.array[front];
		front++;
		return temp;
	}

	public int peek() {
		if (this.array.length == 0) {
			throw new RuntimeException("Queue is empty");
		}
		return this.array[front];
	}
}
