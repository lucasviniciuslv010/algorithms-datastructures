package com.lucasvinicius.datastructures.linkedlist;

public interface ILinkedList<T> {
	
	int size();
	
	boolean isEmpty();
	
	T get(int index);
	
	T getFirst();
	
	T getLast();
	
	T set(int index, T elem);
	
	boolean add(T elem);
	
	void addAt(int index, T elem);
	
	void addFirst(T elem);
	
	void addLast(T elem);
	
	boolean remove(T elem);
	
	T removeAt(int index);
	
	T removeFirst();
	
	T removeLast();
	
	int indexOf(T elem);
	
	void clear();

}
