package com.lucasvinicius.datastructures.circularqueue;

public interface ICircularQueue<T> {
	
	int size();

	boolean isEmpty();
	
	void enqueue(T elem);
	
	T dequeue();
	
	T peek();
	
	void clear();

}