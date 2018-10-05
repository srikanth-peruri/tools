package com.speruri.latest.algorithms.arrays;

public class LongWrapper {

	private final Object key = new Object();
	private volatile long l;
	
	public LongWrapper(long lo){
		this.l = lo;
	}
	
	public void increment(){
//		synchronized(key){
			l = l + 1;
//		}
	}
	
	public long getValue(){
		return l;
	}

}
