package com.speruri.mutlithreading.advance;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorsTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		// Runnable task = () -> System.out.println("Hi this is thread " +
		// Thread.currentThread().getName());

		// for (int i = 0; i < 10; i++) {
		// new Thread(task).start();
		// }
		//

		
		Callable<String> task = () -> {
			Thread.sleep(300);
			return "Hi this is thread " + Thread.currentThread().getName();
		};
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			Future<String> future = executorService.submit(task);
			System.out.println(future.get(300,TimeUnit.MILLISECONDS));
		}

		executorService.shutdown();

		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(8);
	}
}
