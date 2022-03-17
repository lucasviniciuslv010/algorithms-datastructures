package com.lucasvinicius.datastructures.stack;

public interface IStack<T> {

	int size();

	boolean isEmpty();
	
	T push(T elem);
	
	T pop();
	
	T peek();
	
	void clear();
	
}