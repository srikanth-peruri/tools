package com.speruri.mutlithreading;

import com.speruri.mutlithreading.ProducerConsumer.Consumer;
import com.speruri.mutlithreading.ProducerConsumer.Producer;

public class ProducerConsumer {

	private static Object lock = new Object();

	private static int[] buffer;
	private static int count;

	public static boolean isFull() {
		return buffer.length == count;
	}

	public static boolean isEmpty(int[] buffer) {
		return count == 0;
	}

	static class Producer {

		void produce() {
			synchronized (lock) {
				if (isFull()) {
					try {
						lock.wait();
						System.out.println("Someone consumed the values...Hence producing.");
					} catch (InterruptedException e) {
					}
				}
				buffer[count++] = 1;
				lock.notify();
			}
		}
	}

	static class Consumer {

		void consume() {
			synchronized (lock) {
				if (isEmpty(buffer)) {
					try {
						lock.wait();
						System.out.println("Someone produced the values...Hence consuming.");
					} catch (InterruptedException e) {
					}
				}
				buffer[--count] = 0;
				lock.notify();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		buffer = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable produceTask = () -> {
			for (int i = 0; i < 50; i++) {
				producer.produce();
			}
			System.out.println("Done producing");
		};
		Runnable consumeTask = () -> {
			for (int i = 0; i < 50; i++) {
				consumer.consume();
			}
			System.out.println("Done consuming");
		};

		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);

		consumerThread.start();
		producerThread.start();

		consumerThread.join();
		producerThread.join();

		System.out.println("Data in the buffer: " + count);
	}
}
