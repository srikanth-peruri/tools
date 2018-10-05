package com.speruri.latest.algorithms.arrays;

public class Singleton {
	
	private static Singleton singleton = null;
	
	//Make the constructor private for not making others to instantiate this class
	private Singleton(){
		
	}
	
	//This is the naive implementation without considering the multi threaded env
	
	public synchronized static Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;		
	}

}
