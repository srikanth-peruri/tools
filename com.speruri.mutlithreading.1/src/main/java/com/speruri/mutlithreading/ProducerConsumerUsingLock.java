package com.speruri.mutlithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.management.RuntimeErrorException;

public class ProducerConsumerUsingLock {
	private static List<Integer> buffer = new ArrayList<Integer>();

	public static boolean isEmpty() {
		return buffer.size() == 0;
	}

	public static boolean isFull() {
		return buffer.size() == 10;
	}

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition isFull = lock.newCondition();
		Condition isEmpty = lock.newCondition();

		class Producer implements Callable<String> {

			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 50) {
					try {
						lock.lock();
						int i = 10 / 0;
						while (isFull()) {
							if (!isFull.await(100, TimeUnit.MILLISECONDS)) {
								throw new TimeoutException("Consumer timed out while producing");
							}
						}

						buffer.add(1);
						isEmpty.signalAll();
					} finally {
						lock.unlock();
					}
				}
				return "Produced Iteqms count is : " + (count - 1);
			}

		}

		class Consumer implements Callable<String> {

			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 50) {
					try {
						lock.lock();
						while (isEmpty()) {
							if (!isEmpty.await(100, TimeUnit.MILLISECONDS)) {
								throw new TimeoutException("Consumer timed out while consuming");
							}
						}
						buffer.remove(buffer.size() - 1);
						isFull.signalAll();
					} finally {
						lock.unlock();
					}
				}
				return "Consumed Items count is : " + (count - 1);
			}
		}

		int noOfProducers = 4;
		int noOfConsumers = 4;

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
