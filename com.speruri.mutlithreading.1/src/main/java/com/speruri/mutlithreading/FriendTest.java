package com.speruri.mutlithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FriendTest {
	public static void main(String[] args) {
		int noOfFriends = 4;
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CyclicBarrier cyclicBarrier = new CyclicBarrier(noOfFriends, () -> System.out.println("Barrier is starting.."));

		try {
			List<Future<String>> futures = new ArrayList<>();
			for (int i = 0; i < noOfFriends; i++) {
				Friend friend = new Friend(cyclicBarrier);
				Future<String> future = executorService.submit(friend);
				futures.add(future);
			}

			futures.forEach(future -> {
				try {
					future.get(200, TimeUnit.MILLISECONDS);
				} catch (InterruptedException | ExecutionException e) {
					System.out.println(e.getMessage());
				} catch (TimeoutException e) {
					System.out.println("Time out..");
					future.cancel(true);
				}
			});

		} finally {
			executorService.shutdown();
		}

	}
}
