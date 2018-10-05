package com.speruri.latest.algorithms.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class ProducerConsumerOperations {

	private Object lock = new Object();
	int capacity = 5;
	int counter = 0;
	private int[] items = new int[capacity];

	private boolean isFull() {
		return this.counter == capacity;
	}

	private boolean isEmpty() {
		return this.counter == 0;
	}

	public void produce() throws InterruptedException {
		synchronized (lock) {
			while (isFull()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Adding item");
			items[counter++] = 1;
			lock.notifyAll();
			Thread.sleep(50);
		}
	}

	public void consume() throws InterruptedException {
		synchronized (lock) {
			while (isEmpty()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Consuming");
			items[--counter] = 0;
			lock.notifyAll();
			Thread.sleep(50);
		}
	}

	public static void main(String[] args) throws Exception {
		ProducerConsumerOperations pc = new ProducerConsumerOperations();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						pc.produce();
					} catch (InterruptedException e) {
					}
				}
			}
		};
		Callable<Integer> ca = new Callable<Integer>() {
			@Override
			public Integer call() {
				return 1;
			}
		};

		Thread t1 = new Thread(r1);

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						pc.consume();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		java.util.concurrent.ExecutorService e = java.util.concurrent.Executors.newSingleThreadExecutor();
		Future<Integer> f = e.submit(ca);
		System.out.println(f.get());
		e.shutdown();
	}
}
