package com.speruri.mutlithreading.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWriteLock {

	private Map<Long, String> cache = new HashMap<>();
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public String put(Long key, String value) {
		readWriteLock.writeLock().lock();
		try {
			return cache.put(key, value);
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	public String get(Long key) {
		readWriteLock.readLock().lock();
		try {
			return cache.get(key);
		} finally {
			readWriteLock.readLock().unlock();
		}
	}

	public static void main(String[] args) {
		CacheWithReadWriteLock cache = new CacheWithReadWriteLock();

		class Producer implements Callable<String> {
			Random random = new Random();

			@Override
			public String call() throws Exception {
				while (true) {
					long nextInt = random.nextInt(1_000);
					cache.put(nextInt, String.valueOf(nextInt));
					if (cache.get(nextInt) == null) {
						System.out.println("Key : " + nextInt + " has not been inserted into map");
					}
				}
			}

		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		System.out.println("Inserting value...");
		for (int i = 0; i < 4; i++) {
			executorService.submit(new Producer());
		}
		
		executorService.shutdown();
	
	}

}
