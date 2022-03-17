package com.lucasvinicius.algorithms.sorts.bubblesort;

/**
 * Generic Bubble Sort Algorithm
 * 
 * <p>
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in wrong order.
 * >> https://www.geeksforgeeks.org/bubble-sort/
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j+1].compareTo(array[j]) < 0) {
					swap(array, j, j+1);
				}
			}
		}
	}
	
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp        = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}