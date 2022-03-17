package com.lucasvinicius.algorithms.sorts.quicksort;

/**
 * Generic Quick Sort Algorithm
 * 
 * <p>
 * Like Merge Sort, Quick Sort is a Divide and Conquer algorithm. It picks an
 * element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different
 * ways.
 * >> https://www.geeksforgeeks.org/quick-sort/
 * 
 * Here we use the first element of the array as the pivot.
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class QuickSort2 {
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] array, int start, int finish) {
		if (start < finish) {
			int pivotIndex = partition(array, start, finish);
			quickSort(array, start, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, finish);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] array, int start, int finish) {
		int pivotIndex = start;
		T pivot = array[pivotIndex];
		
		while (start < finish) {
			while (array[start].compareTo(pivot) <= 0 && start < finish) {
				start++;
			}	
			while (array[finish].compareTo(pivot) > 0) {
				finish--;
			}
			if (start < finish) {
				swap(array, start, finish);
			}
		}
		
		swap(array, finish, pivotIndex);
		return finish;
	}
	
	private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
		if (index1 != index2) {
			T temp        = array[index1];
			array[index1] = array[index2];
			array[index2] = temp;
		}
	}

}