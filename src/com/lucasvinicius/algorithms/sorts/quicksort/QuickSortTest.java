package com.lucasvinicius.algorithms.sorts.quicksort;

public class QuickSortTest {

	public static void main(String[] args) {
		
		Integer[] array  = new Integer[] { 11, 36, 5, 103, 67, 1, 27, 10, 67, 4, 90 };
		Integer[] array2 = new Integer[] { 11, 36, 5, 103, 67, 1, 27, 10, 67, 4, 90 };

		System.out.println("============== QUICKSORT 1");		
		System.out.println(java.util.Arrays.toString(array));
		System.out.println("-------------------------------------");
		QuickSort.sort(array);
		System.out.println(java.util.Arrays.toString(array));
		
		System.out.println("\n============== QUICKSORT 2");
		System.out.println(java.util.Arrays.toString(array2));
		System.out.println("-------------------------------------");
		QuickSort2.sort(array2);
		System.out.println(java.util.Arrays.toString(array2));

	}

}