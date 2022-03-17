package com.lucasvinicius.datastructures.linkedlist.doubly;

import java.util.NoSuchElementException;
import java.util.Objects;

import com.lucasvinicius.datastructures.linkedlist.ILinkedList;

/**
 * Implementation of our own Doubly Linked List Data Structure.
 * This is done using the DoublyLinkedList and DoublyNode classes.
 * 
 * <p>
 * A Doubly Linked List (DLL) contains an extra pointer, typically called previous pointer,
 * together with next pointer and data which are there in singly linked list.
 * >> https://www.geeksforgeeks.org/doubly-linked-list/
 * 
 * Linked lists can be of several types: singly, doubly, and circular linked lists. 
 *
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 * */

public class DoublyLinkedList<T> implements ILinkedList<T> {
	
	private DoublyNode<T> head;
	private DoublyNode<T> tail;
	
	private int size;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public DoublyLinkedList(T[] array) {
		if (array == null) {
			throw new NullPointerException();
		}
		for (T elem : array) {
			add(elem);
		}
	}
	
	private DoublyNode<T> getNode(int index) {
		DoublyNode<T> node;
		
		if (index < size / 2) {
			node = head;
			
			for (int i=0; i < index; i++) {
				node = node.getNext();		
			}
			
		} else {
			node = tail;
			
			for (int i = size - 1; i > index; i--) {
				node = node.getPrev();
			}
			
		}
		
		return node;
	}
	
	private void removeNode(DoublyNode<T> node) {
		if (size == 1) {
			head = null;
			tail = null;
		} else if (node == head) {
			head = head.getNext();
			head.setPrev(null);
		} else if (node == tail) {
			tail = tail.getPrev();
			tail.setNext(null);
		} else {
			DoublyNode<T> prev = node.getPrev();
			DoublyNode<T> next = node.getNext();
			prev.setNext(next);
			next.setPrev(prev);
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
		DoublyNode<T> node = getNode(index);
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
	public void addAt(int index, T data) {
	    checkIfTheIndexIsAvailable(index);
	    if (index == 0) {
	      addFirst(data);
	    } else if (index == size) {
	      addLast(data);
	    } else {
	    	DoublyNode<T> next    = getNode(index);
	    	DoublyNode<T> prev    = next.getPrev();
	    	DoublyNode<T> newNode = new DoublyNode<>(data, prev, next);
	    	prev.setNext(newNode);
	    	next.setPrev(newNode);
	    }
	    size++;
	}
	
	@Override
	public void addFirst(T elem) {
		if (isEmpty()) {
			DoublyNode<T> newNode = new DoublyNode<>(elem, null, null);
			head = newNode;
			tail = newNode;
		} else {
			head.setPrev(new DoublyNode<>(elem, null, head));
			head = head.getPrev();
		}
		size++;
	}
	
	@Override
	public void addLast(T elem) {
		if (isEmpty()) {
			DoublyNode<T> newNode = new DoublyNode<>(elem, null, null);
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(new DoublyNode<>(elem, tail, null));
			tail = tail.getNext();
		}
		size++;
	}
	
	@Override
	public boolean remove(T elem) {
		DoublyNode<T> aux = head;
		while (aux != null) {
			if (Objects.equals(elem, aux.getData())) {
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
		DoublyNode<T> node = getNode(index);
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
		DoublyNode<T> aux = head;
		for (int i=0; i < size; i++) {
			if (Objects.equals(elem, aux.getData())) {
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
		
		DoublyNode<T> aux = head;
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