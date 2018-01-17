package com.speruri.mutlithreading.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class AtomicCounter {

	private static Object lock = new Object();
	private static AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		class Incrementer implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					counter.incrementAndGet();
				}
			}
		}

		class Decrementer implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 1_000; i++) {
					counter.decrementAndGet();
				}
			}
		}

		ExecutorService executorService = Executors.newFixedThreadPool(8);
		List<Future<?>> futures = new ArrayList<>();

		try {
			for (int i = 0; i < 4; i++) {
				futures.add(executorService.submit(new Incrementer()));
			}
			for (int i = 0; i < 4; i++) {
				futures.add(executorService.submit(new Decrementer()));
			}

			futures.forEach(future -> {
				try {
					future.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});

			System.out.println("Counter value finally is : " + counter);
		} finally {
			executorService.shutdown();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken : " + (endTime - startTime));
	}
}
