package com.lucasvinicius.algorithms.searches.binarysearch;

public class BinarySearchTest {

	public static void main(String[] args) {
		
		// make sure your array is sorted. Binary-Search works on sorted array.
		Integer[] array = { 10, 25, 32, 45, 55, 68, 71, 87 };

		int result = BinarySearch.search(array, 100);
		System.out.println((result == -1) 
				? "Element Not Found" : "Element Found At Index "+result);

		int result2 = BinarySearch.search(array, 68);
		System.out.println((result2 == -1) 
				? "Element Not Found" : "Element Found At Index "+result2);

	}

}