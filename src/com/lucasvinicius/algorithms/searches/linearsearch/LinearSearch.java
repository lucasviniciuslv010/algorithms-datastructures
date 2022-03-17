package com.lucasvinicius.algorithms.searches.linearsearch;

/**
 * Linear Search || Sequential Search
 * 
 * <p>
 * Linear search is a very simple search algorithm.
 * In this type of search, a sequential search is made over all items one by one. 
 * 
 * Linear search is rarely used practically because other search algorithms such
 * as the binary search algorithm and hash tables allow significantly
 * faster-searching comparison to Linear search.
 * >> https://www.geeksforgeeks.org/linear-search/
 * 
 * Worst-case performance      O(n)
 * Best-case performance       O(1)
 * Average performance         O(n)
 * Worst-case space complexity O(1)
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class LinearSearch {

	public static <T extends Comparable<T>> int search(T[] array, T elem) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(elem) == 0) {
				return i;
			}
		}
		return -1;
	}

}