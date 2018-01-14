package com.speruri.mutlithreading;

public class LongWrapper {

	private Object key = new Object();
	private long value;

	public LongWrapper(long argValue) {
		this.value = argValue;
	}

	public long getValue() {
		return value;
	}

	public void increamentValue() {
		synchronized (key) {
			this.value++;
		}
	}

}
