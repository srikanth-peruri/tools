package com.speruri.latest.algorithms.java.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		// Product p1 = new Product("1", "Door", 2);
		// Product p2 = new Product("2", "Window", 3);
		// Product p3 = new Product("3", "LIving room", 4);
		// Collection<Product> products = new ArrayList<>();
		// products.add(p1);
		// products.add(p2);
		// products.add(p3);
		//
		// Product p4 = new Product("4", "Custom product", 5);
		//
		// // Iterator<Product> iterator = products.iterator();
		// // while (iterator.hasNext()) {
		// // Product product = iterator.next();
		// // if (product.getWeight() == 4) {
		// //// System.out.println(product);
		// // product.setWeight(7);
		// // }
		// // }
		//
		// // System.out.println(products.toString());
		// // Instead of using this iterator , we use the foreach loop which was
		// // introduced in java 5.
		// // It internally calls this iterator and navigates the collection
		// // While iterating with the foreach loop, we cannot remove the
		// element.
		// // It throws ConcurrentModificationException
		//
		// /*
		// * for (Product product : products) { System.out.println(product);
		// *
		// * }
		// */
		//
		// //
		// // Shipment shipment = new Shipment();
		// // shipment.add(ProductFixtures.window);
		// // shipment.add(ProductFixtures.floorPanel);
		// // shipment.add(ProductFixtures.door);
		// //
		// // Iterator<Product> iterator = shipment.iterator();
		// // while(iterator.hasNext()){
		// // Product p = iterator.next();
		// // if(p.getWeight() > 20){
		// // System.out.println(p);
		// // } else {
		// // iterator.remove();
		// // }
		// // }
		// //
		//
		// Map<String, Product> map = new HashMap<>();
		//
		// map.put(ProductFixtures.door.getId(), ProductFixtures.door);
		// map.put(ProductFixtures.window.getId(), ProductFixtures.window);
		// map.put(ProductFixtures.floorPanel.getId(),
		// ProductFixtures.floorPanel);
		//
		// // Set<Product> set = new HashSet<>();
		// // set.add(ProductFixtures.door);
		// // set.add(ProductFixtures.floorPanel);
		// // set.add(ProductFixtures.window);
		//
		// // Collection<Product> list = map.values();
		// // list.remove(ProductFixtures.door);
		//
		// // Set<Map.Entry<String, Product>> entrySet = map.entrySet();
		// // for (Map.Entry<String, Product> entry : entrySet) {
		// // entrySet.remove(ProductFixtures.door);
		// // }
		//
		// System.out.println("Product is : " + map.getOrDefault("13", p4));

		Animal lion1 = new Animal(1, "Male", "Lion", 10);
		Animal lion2 = new Animal(2, "Male", "Lion", 9);
		Animal lion3 = new Animal(3, "Male", "Lion", 8);
		Animal lion4 = new Animal(4, "Male", "Lion", 7);
		Animal lion5 = new Animal(5, "Male", "Lion", 6);

		Animal tiger = new Animal(1, "Female", "Tiger", 9);
		Animal tiger1 = new Animal(2, "Female", "Tiger", 7);
		Animal tiger2 = new Animal(3, "Female", "Tiger", 5);
		Animal tiger3 = new Animal(4, "Female", "Tiger", 3);
		Animal tiger4 = new Animal(5, "Female", "Tiger", 6);

		Animal monkey = new Animal(1, "Male", "monkey", 11);
		Animal monkey1 = new Animal(2, "Female", "monkey", 6);
		Animal monkey2 = new Animal(3, "Male", "monkey", 5);
		Animal monkey3 = new Animal(4, "Female", "monkey", 2);
		Animal monkey4 = new Animal(5, "Male", "monkey", 1);

		List<Animal> animalList = new ArrayList<Animal>();
		animalList.add(lion1);
		animalList.add(lion2);
		animalList.add(lion3);
		animalList.add(lion4);
		animalList.add(lion5);
		animalList.add(tiger);
		animalList.add(tiger1);
		animalList.add(tiger2);
		animalList.add(tiger3);
		animalList.add(tiger4);
		animalList.add(monkey);
		animalList.add(monkey1);
		animalList.add(monkey2);
		animalList.add(monkey3);
		animalList.add(monkey4);

		Comparator<Animal> comp = new Comparator<Animal>() {
			@Override
			public int compare(Animal a1, Animal a2) {
				return Integer.compare(a2.getFoodQuantityPerday(), a1.getFoodQuantityPerday());
			}
		};

		animalList.sort(comp);
		// animalList.forEach(System.out::println);

		Map<Animal, Long> map = animalList.stream().collect(java.util.stream.Collectors
				.groupingBy(java.util.function.Function.identity(), java.util.stream.Collectors.counting()));
		map.forEach((key, value) -> System.out.println(key + "->" + value));

	}
}