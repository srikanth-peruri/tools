package com.speruri.mutlithreading;

public class Singleton {
	private static Singleton singleton;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (singleton != null) {
			return singleton;
		}

		synchronized (singleton) {
			if (singleton == null) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}

}
