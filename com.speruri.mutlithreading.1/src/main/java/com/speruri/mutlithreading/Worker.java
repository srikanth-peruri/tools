package com.speruri.mutlithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Callable<List<Integer>> {

	private CyclicBarrier cyclicBarrier;
	private List<Integer> integerList;

	public Worker(CyclicBarrier argCyclicBarrier, List<Integer> argIntegerList) {
		this.cyclicBarrier = argCyclicBarrier;
		this.integerList = argIntegerList;
	}

	@Override
	public List<Integer> call() throws Exception {
		List<Integer> primeNumberList = findPrimes();
		try {
			this.cyclicBarrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return primeNumberList;
	}

	private List<Integer> findPrimes() {
		List<Integer> newPrimesList = new ArrayList<>();
		if(this.integerList != null && this.integerList.size() > 0){
			for (Integer integerValue : newPrimesList) {
				if(integerValue % 2 == 0){
					newPrimesList.add(integerValue);
				}
			}
		}
		return newPrimesList;
	}

}
