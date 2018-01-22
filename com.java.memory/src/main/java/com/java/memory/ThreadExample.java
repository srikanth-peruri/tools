package com.java.memory;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample {
	private static Object lock = new Object();
	private static HashMap<String, Object> map = new HashMap();

	public static void main(String[] args) {
		Runnable runnable = () -> {
			while (true) {
				try {
					for (int i = 0; i < 1000; i++) {
						String str = "Created by : " + Thread.currentThread().getName();
						str += str;
						str += str;
						str += str;
						System.out.println(new String(str));
						map.put(str, new ThreadExample());
						Thread.sleep(100);
						map.remove(str);
						lock = map.get(str);
						System.out.println("map :" + lock);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		ExecutorService executorService = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++) {
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}
