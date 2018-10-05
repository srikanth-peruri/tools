package com.speruri.latest.algorithms.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public class MyThread implements Runnable {
		java.util.concurrent.Semaphore sem;
		String threadName;

		public MyThread(Semaphore argSem, String name) {
			this.sem = argSem;
			this.threadName = name;
		}

		@Override
		public void run() {
			if (this.threadName == "A") {
				// Acquire the semaphore
				try {
					// If the counter is > 0, then it aquires the lock or else
					// waits
					sem.acquire();
					// if counter is greater than 0, then counter will get
					// decremented
					Thread.sleep(100);
					sem.release();
					// counter will incremented
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
	}
}
