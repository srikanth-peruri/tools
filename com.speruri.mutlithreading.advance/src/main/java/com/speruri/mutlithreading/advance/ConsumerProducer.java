package com.speruri.mutlithreading.advance;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConsumerProducer {

	private static Object key = new Object();
	private static int[] bytes;
	private static int count;

	static class Producer {

		public int produce() {
			int producedCount = 0;
			synchronized (key) {
				if (isFull()) {
					try {
						System.out.println("Waiting for filling the buffer");
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				}
				bytes[count++] = 1;
				producedCount++;
				System.out.println("Produced by " + Thread.currentThread().getName());
				key.notify();
			}
			return producedCount;
		}

	}

	static class Consumer {
		public int consume() {
			int consumedCount = 0;
			synchronized (key) {
				if (isEmpty()) {
					try {
						System.out.println("Waiting for the buffer to consume");
						key.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				bytes[--count] = 0;
				consumedCount++;
				System.out.println("Consumed by " + Thread.currentThread().getName());
				key.notify();
			}
			return consumedCount;
		}
	}

	public static boolean isEmpty() {
		return count == 0;
	}

	public static boolean isFull() {
		return count == bytes.length;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		bytes = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		int noOfProducers = 10;
		int noOfConsumers = 50;

		Callable<Integer> producerRunnable = () -> {
			int producedCount = 0;
			for (int i = 0; i < noOfProducers; i++) {
				producedCount += producer.produce();
			}
			System.out.println("Done producing");
			return producedCount;
		};

		Callable<Integer> consumerRunnable = () -> {
			int consumedCount = 0;
			for (int i = 0; i < noOfConsumers; i++) {
				consumedCount += consumer.consume();
			}
			System.out.println("Done consuming");
			return consumedCount;
		};

		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<Integer> consumerFuture = service.submit(consumerRunnable);
		Future<Integer> producerFuture = service.submit(producerRunnable);

		//
		// Thread producerThread = new Thread(producerRunnable);
		// Thread consumerThread = new Thread(consumerRunnable);
		//
		// producerThread.start();
		// consumerThread.start();
		//
		// producerThread.join();
		// consumerThread.join();

		System.out.println("Producer produced : " + producerFuture.get() );
		System.out.println("Consumer Consumed : " + consumerFuture.get() );
		
		System.out.println("Final count is : " + count);
		service.shutdown();

	}

}
