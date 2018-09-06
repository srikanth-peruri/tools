package com.speruri.latest.algorithms.java.practice;

public class ProductFixtures {

	public static Product door = new Product("Wooden Door", 35);
	public static Product floorPanel = new Product("Floor Panel", 25);
	public static Product window = new Product("Window", 10);

	public static Supplier bobs = new Supplier("Bob's Household Products");
	public static Supplier kates = new Supplier("Kate's Household Products");
	
	
	static{
		bobs.getProducts().add(door);
		bobs.getProducts().add(floorPanel);
			
		kates.getProducts().add(floorPanel);	
		kates.getProducts().add(door);
	}
}