package com.speruri.mutlithreading;

public class LongWrapperTest {
	public static void main(String[] args) throws InterruptedException {
		LongWrapper longWrapper = new LongWrapper(0L);
		Runnable r = () -> {
			for (int i = 0; i < 1_000; i++) {
				System.out.println("[" + Thread.currentThread().getName() + "] :: Incrementing");
				longWrapper.increamentValue();
			}
		};

		Thread[] threads = new Thread[1000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
//			threads[i].join();
		}
		

		System.out.println("Final value of the long wrapper is  " + longWrapper.getValue());
	}
}
