package com.speruri.latest.algorithms.arrays;

public class CallingA {
	public static void main(String[] args) throws InterruptedException {

		DeadLockCode a = new DeadLockCode();

		Runnable r1 = () -> {
			a.methodA();
		};
		Runnable r2 = () -> {
			a.methodB();
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}
}
