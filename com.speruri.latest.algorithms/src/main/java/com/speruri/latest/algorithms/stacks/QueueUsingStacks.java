package com.speruri.latest.algorithms.stacks;

import java.util.Stack;

public class QueueUsingStacks {

	private Stack<Integer> stackToPush;
	private Stack<Integer> stackToPop;

	public QueueUsingStacks() {
		stackToPush = new Stack<Integer>();
		stackToPop = new Stack<Integer>();
	}

	public void shiftStacks() {
		while (!stackToPush.isEmpty()) {
			stackToPop.push(stackToPush.pop());
		}
	}

	public void push(int item) {
		this.stackToPush.push(item);
	}

	public int pop() {
		if (stackToPop.isEmpty()) {
			shiftStacks();
		}
		if (!stackToPop.isEmpty()) {
			return this.stackToPop.pop();
		}
		return -1;
	}

	public static void main(String[] args) {
		QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
		queueUsingStacks.push(1);
		queueUsingStacks.push(2);
		queueUsingStacks.push(3);
		queueUsingStacks.push(4);
		queueUsingStacks.push(5);
		System.out.println(queueUsingStacks.pop());
		System.out.println(queueUsingStacks.pop());
		queueUsingStacks.push(6);
		System.out.println(queueUsingStacks.pop());
		System.out.println(queueUsingStacks.pop());
		System.out.println(queueUsingStacks.pop());
		System.out.println(queueUsingStacks.pop());
		System.out.println(queueUsingStacks.pop());
	}

}
