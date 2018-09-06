package com.speruri.latest.algorithms.java.practice;

import java.util.List;
import java.util.ArrayList;

public class Supplier<Product> {
	
	private String name;
	private List<Product> products;
	
	public Supplier(String argName){
		this.name = argName;
		this.products = new ArrayList<>();
	}	
	
	public List<Product> getProducts(){
		return products;	
	}	


}
