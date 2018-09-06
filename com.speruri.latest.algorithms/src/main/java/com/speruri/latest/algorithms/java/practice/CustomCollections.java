package com.speruri.latest.algorithms.java.practice;

import java.util.Collection;
import java.util.Iterator;

public class CustomCollections<E> implements Collection<E> {

	@Override
	public boolean add(E e) {
		// Add an element to this collection
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// Add all the elements of argument collection to this collection
		return false;
	}

	@Override
	public void clear() {
		// clear all the elements from this collection

	}

	@Override
	public boolean contains(Object o) {
		// Check whether this collection contains the argument object or not
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// Check whether this collection contains all the elements in the
		// argument collection
		return false;
	}

	@Override
	public boolean isEmpty() {
		// Check whether this collection is empty or not
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// Iterator is the implementation of Iterable which acts like a cursor
		// of this collection which helps in navigating this collection
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// Remove the argument object from this collection if presents and
		// return true if removed or else false;
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// Remove all the elements from this collection which matches with the
		// collections passed
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// Remove all the elements from this collection and add the collections
		// we got.
		return false;
	}

	@Override
	public int size() {
		// return the size of this collection elements
		return 0;
	}

	@Override
	public Object[] toArray() {
		// Generated an array with this collection elements
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// Generated the elements of this collection type and return
		return null;
	}

}
