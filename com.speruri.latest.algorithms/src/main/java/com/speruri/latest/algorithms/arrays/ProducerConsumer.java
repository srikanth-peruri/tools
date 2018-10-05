package com.speruri.latest.algorithms.arrays;

public class ProducerConsumer {

	private int buffer[];
	private int count;
	private Object lock = new Object();

	public ProducerConsumer(int cap) {
		this.buffer = new int[cap];
		this.count = 0;
	}

	private class Producer {

		public void produce() {
			synchronized (lock) {
				if (isFull()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				System.out.println(java.util.Arrays.toString(buffer));
				lock.notify();
			}
		}

	}

	private class Consumer {
		public void consume() {
			synchronized (lock) {
				if (isEmpty()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				System.out.println(java.util.Arrays.toString(buffer));
				lock.notify();
			}
		}
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == buffer.length;
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer(10);
		Producer producer = pc.new Producer();
		Consumer consumer = pc.new Consumer();

		Runnable p = () -> {
			for (int i = 0; i < 50; i++) {
				producer.produce();
			}
		};

		Runnable c = () -> {
			for (int i = 0; i < 45; i++) {
				consumer.consume();
			}
		};

		Thread pt = new Thread(p);
		Thread ct = new Thread(c);

		pt.start();
		ct.start();

		pt.join();
		ct.join();

		System.out.println("Final count is : " + pc.count);

	}

}
