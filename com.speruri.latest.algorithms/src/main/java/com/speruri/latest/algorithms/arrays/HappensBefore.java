package com.speruri.latest.algorithms.arrays;

public class HappensBefore {

	private int i;

	public synchronized void increment() {
		i++;
	}

	public synchronized void print() {
		System.out.println("For thread " + Thread.currentThread().getName() + " : " + i);
	}

	public static void main(String[] args) throws Exception {
		HappensBefore h = new HappensBefore();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				h.increment();
				h.print();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 50; i++) {
				h.increment();
				h.print();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		System.out.println("For thread " + Thread.currentThread().getName() + " : " + h.i);

	}

}
