package com.speruri.latest.algorithms.java.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import com.speruri.latest.algorithms.java.practice.Product;

public class Main {

	public static void main(String[] args) {
		
		
		
		/*
		Product p1 = new Product("Door", 2);
		Product p2 = new Product("Window", 3);
		Product p3 = new Product("LIving room", 4);
		Collection<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		Product p4 = new Product("Custom product",5);

		
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getWeight() == 4) {
				System.out.println(product);
			} else {
				iterator.remove();
			}
		}
		*/
		// Instead of using this iterator , we use the foreach loop which was
		// introduced in java 5.
		// It internally calls this iterator and navigates the collection
		// While iterating with the foreach loop, we cannot remove the element.
		// It throws ConcurrentModificationException

		/*
		for (Product product : products) {
			System.out.println(product);

		}*/

		
		Shipment shipment = new Shipment();
		shipment.add(ProductFixtures.window);
		shipment.add(ProductFixtures.floorPanel);
		shipment.add(ProductFixtures.door);
		
		Iterator<Product> iterator = shipment.iterator();
		while(iterator.hasNext()){
			Product p = iterator.next();
			if(p.getWeight() > 20){				
				System.out.println(p);
			} else {
				iterator.remove();	
			}	
		}
		
		 
		
	}
}