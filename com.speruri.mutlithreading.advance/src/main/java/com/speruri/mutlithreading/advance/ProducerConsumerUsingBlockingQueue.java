package com.speruri.mutlithreading.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProducerConsumerUsingBlockingQueue {
	private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(50);

	public static void main(String[] args) {

		class Producer implements Callable<String> {

			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 50) {
					blockingQueue.take();
				}
				return Thread.currentThread().getName() + " Produced Iteqms count is : " + (count - 1);
			}

		}

		class Consumer implements Callable<String> {

			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 50) {
					blockingQueue.put(Integer.toString(count));
				}
				return Thread.currentThread().getName() + " Consumed Items count is : " + (count - 1);
			}
		}

		int noOfProducers = 2;
		int noOfConsumers = 2;

		List<Callable<String>> callables = new ArrayList<>();
		for (int i = 0; i < noOfProducers; i++) {
			callables.add(new Producer());
		}

		for (int i = 0; i < noOfConsumers; i++) {
			callables.add(new Consumer());
		}

		ExecutorService executorService = Executors.newFixedThreadPool(noOfProducers + noOfConsumers);

		try {
			List<Future<String>> futures = executorService.invokeAll(callables);

			futures.forEach(future -> {
				try {
					System.out.println(future.get());
				} catch (InterruptedException | ExecutionException e2) {
					e2.printStackTrace();
				}
			});

		} catch (Exception e) {
			throw new RuntimeException("");
		} finally {
			executorService.shutdown();
			System.out.println("Shutting down the executor service");
		}

	}
}
