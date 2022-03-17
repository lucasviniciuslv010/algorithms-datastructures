package com.lucasvinicius.datastructures.linkedlist.singly;

/**
 * Class to represent a node in the list. Holds a single element.
 */
public class SinglyNode<T> {
	
	private T data;
	private SinglyNode<T> next;
	
	public SinglyNode(T data, SinglyNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SinglyNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyNode<T> next) {
		this.next = next;
	}
	
}