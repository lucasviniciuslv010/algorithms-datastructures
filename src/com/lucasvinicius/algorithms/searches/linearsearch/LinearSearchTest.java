package com.lucasvinicius.algorithms.searches.linearsearch;

public class LinearSearchTest {

	public static void main(String[] args) {

		Integer[] array = { 10, 25, 32, 45, 55, 68, 71, 87 };

		int result = LinearSearch.search(array, 100);
		System.out.println((result == -1) 
				? "Element Not Found" : "Element Found At Index "+result);

		int result2 = LinearSearch.search(array, 68);
		System.out.println((result2 == -1) 
				? "Element Not Found" : "Element Found At Index "+result2);

	}

}