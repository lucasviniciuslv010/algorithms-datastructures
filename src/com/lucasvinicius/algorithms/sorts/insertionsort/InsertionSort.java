package com.lucasvinicius.algorithms.sorts.insertionsort;

/**
 * Generic Insertion Sort Algorithm
 * 
 * <p>
 * Insertion Sort is a simple sorting algorithm that works similar to the way
 * you sort playing cards in your hands. The array is virtually split into a
 * sorted and an unsorted part. Values from the unsorted part are picked and
 * placed at the correct position in the sorted part.
 * >> https://www.geeksforgeeks.org/insertion-sort/
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class InsertionSort {

	public static <T extends Comparable<T>> void sort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			int elemIndex = i;
			for (int j = i - 1; j >= 0 && array[j].compareTo(array[elemIndex]) > 0; j--) {
				swap(array, j, elemIndex);
				elemIndex = j;
			}
		}
	}
	
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp        = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}