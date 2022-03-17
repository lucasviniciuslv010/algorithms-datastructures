package com.lucasvinicius.datastructures.linkedlist.singly;

import java.util.NoSuchElementException;

import com.lucasvinicius.datastructures.linkedlist.ILinkedList;

/**
 * Implementation of our own Singly Linked List Data Structure.
 * This is done using the SinglyLinkedList and SinglyNode classes.
 * 
 * <p>
 * A linked list is a linear data structure, in which the elements are not
 * stored at contiguous memory locations. The elements in a linked list are
 * linked using pointers. In simple words, a singly linked list consists of nodes
 * where each node contains a data field and a reference(link) to the next node in the
 * list.
 * >> https://www.geeksforgeeks.org/data-structures/linked-list/
 * 
 * Linked lists can be of several types: single, double, and circular linked
 * 
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class SinglyLinkedList<T> implements ILinkedList<T> {
	
	private SinglyNode<T> head;
	private SinglyNode<T> tail;
	
	private int size;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public SinglyLinkedList(T[] array) {
		if (array == null) {
			throw new NullPointerException();
		}
		for (T elem : array) {
			add(elem);
		}
	}
	
	private SinglyNode<T> getNode(int index) {
		SinglyNode<T> node = head;
		
		for (int i=0; i < index; i++) {
			node = node.getNext();		
		}
		
		return node;
	}
	
	private void removeNode(SinglyNode<T> node) {
		if (size == 1) {
			head = null;
			tail = null;
		} else if (node == head) {
			head = head.getNext();
		} else if (node == tail) {
			tail = getNode(size - 2);
			tail.setNext(null);
		} else {
			SinglyNode<T> aux = head;
			while (!aux.getNext().equals(node)) {
				aux = aux.getNext();
			}
			aux.setNext(aux.getNext().getNext());
		}
		size--;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public T get(int index) {
		checkIfTheIndexIsInUse(index);
		return getNode(index).getData();
	}
	
	@Override
	public T set(int index, T elem) {
		checkIfTheIndexIsInUse(index);
		SinglyNode<T> node = getNode(index);
		T old = node.getData();
		node.setData(elem);
		return old;
	}
	
	@Override
	public T getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.getData();
	}
	
	@Override
	public T getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.getData();
	}
	
	@Override
	public boolean add(T elem) {
		addLast(elem);
		return true;
	}
	
	@Override
	public void addAt(int index, T elem) {
	    checkIfTheIndexIsAvailable(index);
	    if (index == 0) {
	      addFirst(elem);
	    } else if (index == size) {
	      addLast(elem);
	    } else {
	    	SinglyNode<T> newNode = new SinglyNode<>(elem, null);
	    	SinglyNode<T> prev = getNode(index - 1);
	    	newNode.setNext(prev.getNext());
	    	prev.setNext(newNode);
	    }
	    size++;
	}
	
	@Override
	public void addFirst(T elem) {
		if (isEmpty()) {
			SinglyNode<T> newNode = new SinglyNode<T>(elem, null);
			head = newNode;
			tail = newNode;
		} else {
			SinglyNode<T> newNode = new SinglyNode<T>(elem, head);
			head = newNode;
		}
		size++;
	}
	
	@Override
	public void addLast(T elem) {
		if (isEmpty()) {
			SinglyNode<T> newNode = new SinglyNode<T>(elem, null);
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(new SinglyNode<>(elem, null));
			tail = tail.getNext();
		}
		size++;
	}
	
	@Override
	public boolean remove(T elem) {
		SinglyNode<T> aux = head;
		while (aux != null) {
			if (aux.getData().equals(elem)) {
				removeNode(aux);
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}
	
	@Override
	public T removeAt(int index) {
		checkIfTheIndexIsInUse(index);
		SinglyNode<T> node = getNode(index);
		removeNode(node);
		return node.getData();
	}
	
	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T data = head.getData();
		removeNode(head);
		return data;
	}
	
	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T data = tail.getData();
		removeNode(tail);
		return data;
	}
	
	@Override
	public void clear() {
		if (!isEmpty()) {
			head = null;
			tail = null;
			size = 0;
		}
	}
	
	@Override
	public int indexOf(T elem) {
		SinglyNode<T> aux = head;
		for (int i=0; i < size; i++) {
			if (aux.getData().equals(elem)) {
				return i;
			}
			aux = aux.getNext();
		}
		return -1;
	}
	
	private void checkIfTheIndexIsInUse(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
	}

	private void checkIfTheIndexIsAvailable(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		SinglyNode<T> aux = head;
		for (int i=0; i < size - 1; i++) {
			sb.append(aux.getData());
			sb.append(", ");
			aux = aux.getNext();
		}
		
		if (size > 0) {
			sb.append(aux.getData());
		}
		
		sb.append("]");
		
		return sb.toString();
	}

}