package com.lucasvinicius.datastructures.linkedlist.doubly;

/**
 * Class to represent a node in the list. Holds a single element.
 */
public class DoublyNode<T> {

	private T data;
	private DoublyNode<T> prev;
	private DoublyNode<T> next;

	public DoublyNode(T data, DoublyNode<T> prev, DoublyNode<T> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoublyNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoublyNode<T> prev) {
		this.prev = prev;
	}

	public DoublyNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyNode<T> next) {
		this.next = next;
	}
	
}