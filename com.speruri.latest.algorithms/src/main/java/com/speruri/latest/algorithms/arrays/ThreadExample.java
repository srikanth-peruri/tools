package com.speruri.latest.algorithms.arrays;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
		LongWrapper lo = new LongWrapper(0L);

		Runnable runnable = () -> {
			System.out.println("Executing : " + Thread.currentThread().getName());
			for (int i = 0; i < 1000; i++) {
				lo.increment();
			}
		};

		Thread[] th = new Thread[1000];
		for (int i = 0; i < th.length; i++) {
			Thread t = new Thread(runnable);
			t.start();
			th[i] = t;
		}

		for (int i = 0; i < th.length; i++) {
			th[i].join();
		}

		System.out.println("Updated value : " + lo.getValue());
	}

}
