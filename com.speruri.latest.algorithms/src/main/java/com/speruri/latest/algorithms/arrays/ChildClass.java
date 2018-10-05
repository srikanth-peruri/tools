package com.speruri.latest.algorithms.arrays;

public class ChildClass extends ArrayOperations {
	
	@Override
	public String getMethod() {
		return "From child class";
	}

	public static void main(String[] args) {
		ChildClass c = new ChildClass();
		System.out.println(c.getMethod());
	}
}
