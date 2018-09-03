package com.speruri.latest.algorithms.stacks;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.management.RuntimeErrorException;

public class StackUsingQueues {

	Queue<Integer> firstQueue;
	Queue<Integer> secondQueue;

	public StackUsingQueues() {
		this.firstQueue = new LinkedBlockingQueue<>();
		this.secondQueue = new LinkedBlockingQueue<>();
	}

	public void push(int data) {
		this.firstQueue.add(data);
	}

	public int pop() {
		if (this.firstQueue.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		transferElements();
		return this.secondQueue.poll();
	}

	private void transferElements() {
		int counter = 0;
		Iterator<Integer> iterator = firstQueue.iterator();
		while (iterator.hasNext()) {
			if (counter == firstQueue.size() - 1) {
				break;
			}
			this.secondQueue.add(iterator.next());
			counter++;
		}
		System.out.println(counter);

		Queue<Integer> dummy = this.secondQueue;
		this.secondQueue = this.firstQueue;
		this.firstQueue = dummy;
	}

	public void printStack() {
		if (!this.firstQueue.isEmpty()) {
			Iterator<Integer> iterator = this.firstQueue.iterator();
			String s = "";
			while (iterator.hasNext()) {
				s = " " + iterator.next() + s;
			}
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		StackUsingQueues stack = new StackUsingQueues();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.push(10);
		stack.printStack();
	}
}
