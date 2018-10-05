package com.speruri.latest.algorithms.arrays;

public class DeadLockCode {

	private Object key1 = new Object();
	private Object key2 = new Object();

	public void methodA() {
		synchronized (key1) {
			System.out.println("I am Thread : " + Thread.currentThread().getName() + " Executing in methodA()");
			methodB();
		}
	}

	public void methodB() {
		synchronized (key2) {
			System.out.println("I am thread : " + Thread.currentThread().getName() + " Executing in methodB()");
			methodC();
		}
	}

	public void methodC() {
		synchronized (key1) {
			System.out.println("I am thread : " + Thread.currentThread().getName() + " Executing in methodC()");
		}
	}

}
