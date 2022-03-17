package com.lucasvinicius.algorithms.sorts.bubblesort;

public class BubbleSortTest {
	
	public static void main(String[] args) {

		// Sorted
		Integer[] array1 = new Integer[] { 1, 2, 4, 9, 20, 22, 28, 34, 76, 87, 99, 112 };
		System.out.println(java.util.Arrays.toString(array1));
		System.out.println("----------------------------------------------------------");
		BubbleSort.sort(array1);
		System.out.println(java.util.Arrays.toString(array1));

		System.out.println("\n\n==========================================================\n\n");

		// Inverted
		Integer[] array2 = new Integer[] { 112, 99, 87, 76, 34, 28, 22, 20, 9, 4, 2, 1 };
		System.out.println(java.util.Arrays.toString(array2));
		System.out.println("----------------------------------------------------------");
		BubbleSort.sort(array2);
		System.out.println(java.util.Arrays.toString(array2));

		System.out.println("\n\n==========================================================\n\n");

		// Unsorted
		Integer[] array3 = new Integer[] { 4, 99, 2, 76, 34, 2, 99, 20, 9, 4, 2, 112 };
		System.out.println(java.util.Arrays.toString(array3));
		System.out.println("----------------------------------------------------------");
		BubbleSort.sort(array3);
		System.out.println(java.util.Arrays.toString(array3));

	}

}