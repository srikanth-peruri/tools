package com.speruri.latest.algorithms.selectionsort;

import org.apache.commons.lang.ArrayUtils;

public class SelectionSort {

	public int findIndexOfSmallestElementInArray(int[] itemsList) {
		int smallestIndex = 0;
		int smallestElement = itemsList[0];
		for (int i = 0; i < itemsList.length; i++) {
			int currentElement = itemsList[i];
			if (currentElement < smallestElement) {
				smallestElement = currentElement;
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}

	public int[] getSoretedArrayWithSelectionSort(int[] sourceItemList) {
		int[] sortedList = new int[sourceItemList.length];
		int index = 0;
		for (int item : sourceItemList) {
			int smallestElementIndex = findIndexOfSmallestElementInArray(sourceItemList);
			sortedList[index] = sourceItemList[smallestElementIndex];
			sourceItemList = ArrayUtils.remove(sourceItemList, smallestElementIndex);
			index++;
		}
		return sortedList;
	}

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] sourceItemList = { 5, 3, 6, 2, 10 };
		int[] sortedArray = selectionSort.getSoretedArrayWithSelectionSort(sourceItemList);
		for (int i : sortedArray) {
			System.out.println(i);
		}

	}

}
