package com.speruri.latest.algorithms.java.practice;

public class ProductFixtures {

	public static Product door = new Product("1", "Wooden Door", 35);
	public static Product floorPanel = new Product("2", "Floor Panel", 25);
	public static Product window = new Product("3", "Window", 10);

	public static Supplier bobs = new Supplier("Bob's Household Products");
	public static Supplier kates = new Supplier("Kate's Household Products");

	static {
		bobs.getProducts().add(door);
		bobs.getProducts().add(floorPanel);

		kates.getProducts().add(floorPanel);
		kates.getProducts().add(door);
	}
}
