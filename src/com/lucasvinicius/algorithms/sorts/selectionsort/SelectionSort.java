package com.lucasvinicius.algorithms.sorts.selectionsort;

/**
 * Generic Selection Sort Algorithm
 * 
 * <p>
 * The selection sort algorithm sorts an array by repeatedly finding the minimum
 * element (considering ascending order) from unsorted part and putting it at
 * the beginning.
 * >> https://www.geeksforgeeks.org/selection-sort/
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class SelectionSort {
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int smaller = i; 
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[smaller]) < 0) {
					smaller = j;
				}
			}
			if (smaller != i) {
				swap(array, i, smaller);
			}
		}
	}
	
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp        = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}