package com.speruri.classloading;

public class Main{
	
	public static void main(String[] args){
		com.speruri.classloading.Helper helper = new com.speruri.classloading.Helper();
		System.out.println(helper.getMessage());
		java.lang.String str = new java.lang.String();
		//System.out.println("Value is : " + str.getValue());
	}	
	
}