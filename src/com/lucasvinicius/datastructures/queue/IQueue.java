package com.lucasvinicius.datastructures.queue;

public interface IQueue<T> {
	
	int size();

	boolean isEmpty();
	
	void enqueue(T elem);
	
	T dequeue();
	
	T peek();
	
	void clear();

}