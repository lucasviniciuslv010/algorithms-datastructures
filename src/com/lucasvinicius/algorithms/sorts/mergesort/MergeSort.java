package com.lucasvinicius.algorithms.sorts.mergesort;

/**
 * Generic Merge Sort Algorithm
 * 
 * <p>
 * Like Quick Sort, Merge Sort is a Divide and Conquer algorithm. It divides the
 * input array into two halves, calls itself for the two halves, and then merges
 * the two sorted halves. The merge() function is used for merging two halves.
 * The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and
 * arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 * >> https://www.geeksforgeeks.org/merge-sort/
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class MergeSort {
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private static <T extends Comparable<T>> void mergeSort(T[] array, int start, int finish) {
		if (start < finish) {
			int middle = (start + finish) / 2;
			mergeSort(array, start, middle);
			mergeSort(array, middle + 1, finish);
			merge(array, start, middle, finish);
		}
	}
	
	private static <T extends Comparable<T>> void merge(T[] array, int start, int middle, int finish) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable[array.length];
		
		for (int i = start; i <= finish; i++) {
			tempArray[i] = array[i];
		}
		
		int left  = start;
		int right = middle + 1;
		
		for (int i = start; i <= finish; i++) {
			if (left > middle) {
				array[i] = tempArray[right++];
			} else if (right > finish) {
				array[i] = tempArray[left++];
			} else if (tempArray[left].compareTo(tempArray[right]) < 0) {
				array[i] = tempArray[left++];
			} else {
				array[i] = tempArray[right++];
			}
		}
	}
	
}