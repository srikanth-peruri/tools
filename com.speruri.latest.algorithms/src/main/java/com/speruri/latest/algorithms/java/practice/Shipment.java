package com.speruri.latest.algorithms.java.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

//Embed a collection inside a domain class which deals with the shipments. This is a good programming practice
public class Shipment implements Iterable {

	private final static int MAX_WEIGHT = 20;

	private List<Product> products = new ArrayList<>();

	private List<Product> lightWeightProducts;
	private List<Product> heavyWeightProducts;

	public void add(Product p) {
		products.add(p);
	}

	public Product remove(Product p) {
		int index = products.indexOf(p);
		Product pr = null;
		if (index != -1) {
			pr = products.get(index);
			products.remove(index);
		}
		return pr;
	}

	public void replace(Product old, Product newProduct) {
		int index = products.indexOf(old);
		if (index != -1) {
			products.set(index, newProduct);
		}
	}

	public void prepare() {
		// Sort our products by weight
		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				// return Integer.compare(p1.getWeight(),p2.getWeight());
				if (p1.getWeight() == p2.getWeight()) {
					return 0;
				}

				if (p1.getWeight() < p2.getWeight()) {
					return -1;
				}
				return 1;
			}
		});

		// Find the products that are below the min weight
		int splitPoint = findSplitPoint();
		// split them based on the index
		lightWeightProducts = products.subList(0, splitPoint);
		heavyWeightProducts = products.subList(splitPoint, products.size());

	}

	public int findSplitPoint() {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getWeight() > MAX_WEIGHT) {
				return i;
			}
		}
		return 0;
	}

	public List<Product> getLightVanProducts() {
		return lightWeightProducts;
	}

	public List<Product> getHeavyVanProducts() {
		return heavyWeightProducts;
	}

	@Override
	public Iterator iterator() {
		return products.iterator();
	}

}
