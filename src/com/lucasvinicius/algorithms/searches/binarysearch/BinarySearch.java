package com.lucasvinicius.algorithms.searches.binarysearch;

/**
 * Binary Search
 * 
 * <p>
 * In computer science, binary search, also known as half-interval search or
 * logarithmic search, is a search algorithm that finds the position of a target
 * value within a sorted array.
 * 
 * Binary Search is a searching algorithm used in a sorted array by repeatedly
 * dividing the search interval in half. The idea of binary search is to use the
 * information that the array is sorted and reduce the time complexity to O(Log n).
 * >> https://www.geeksforgeeks.org/binary-search/
 * 
 * Worst-case performance      O(log n)
 * Best-case performance       O(1)
 * Average performance         O(log n)
 * Worst-case space complexity O(1)
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class BinarySearch {
	
	public static <T extends Comparable<T>> int search(T[] array, T elem) {
		return search(array, elem, 0, array.length - 1);
	}
	
	private static <T extends Comparable<T>> int search(T[] array, T elem, int left, int right) {
		if (left <= right) {
			
			int mid = (left + right) / 2;	
			
			if (array[mid].compareTo(elem) == 0) {
				return mid;
			} else if (array[mid].compareTo(elem) < 0) {
				return search(array, elem,  mid + 1, right);
			} else {
				return search(array, elem, left, mid - 1);
			}
			
		}
		return -1;
	}

}