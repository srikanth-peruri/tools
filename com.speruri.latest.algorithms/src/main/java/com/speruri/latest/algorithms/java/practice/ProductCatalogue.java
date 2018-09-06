package com.speruri.latest.algorithms.java.practice;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class ProductCatalogue implements Iterable<Product> {

	public Set<Product> products = new java.util.TreeSet<>(new Comparator<Product>() {
		@Override
		public int compare(Product p1, Product p2) {
			int result = 0;
			if (p1.getWeight() == p2.getWeight()) {
				result = 0;
			} else if (p1.getWeight() < p2.getWeight()) {
				result = -1;
			} else {
				result = 1;
			}
			return result;
		}
	});

	public void isSuppliedBy(Supplier supplier) {
		products.addAll(supplier.getProducts());
	}

	@Override
	public Iterator iterator() {
		return null;
	}

}
