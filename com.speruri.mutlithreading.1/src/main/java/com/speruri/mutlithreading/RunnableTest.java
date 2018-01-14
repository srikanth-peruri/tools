package com.speruri.mutlithreading;

public class RunnableTest {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			System.out.println("I am running the task with thread : " + Thread.currentThread().getName());
		};

		Thread t = new Thread(runnable);
		t.start();
		
		Thread t1 = new Thread(runnable);
		t1.setName("My Thread");
		t1.start();
	}
}
