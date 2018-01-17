package com.speruri.mutlithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Friend implements Callable<String> {

	private CyclicBarrier cyclicBarrier;

	public Friend(CyclicBarrier argCyclicBarrier) {
		this.cyclicBarrier = argCyclicBarrier;
	}

	@Override
	public String call() throws Exception {
		Random random = new Random();
		Thread.sleep(random.nextInt(20) * 100 + 100);
		System.out.println(Thread.currentThread().getName() + " just arrived, waiting for others to come..");
		this.cyclicBarrier.await(5, TimeUnit.SECONDS);
		System.out.println("Everyone Arrived, Let's go to a movie..");
		return "Ok";
	}

}
