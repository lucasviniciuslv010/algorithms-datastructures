package com.lucasvinicius.datastructures.stack.array_stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Implementation of our own Stack Data Structure (Using Array)
 * 
 * <p>
 * Stack is a linear data structure which follows a particular order
 * in which the operations are performed.
 * The order may be LIFO(Last In First Out) or FILO(First In Last Out).
 * That is, the last item added to the stack will be the first item
 * to be removed.
 * >> https://www.geeksforgeeks.org/stack-data-structure/
 * 
 * Stacks, in theory, have no fixed size, but when using an array
 * implementation this happens.
 *
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

import com.lucasvinicius.datastructures.stack.IStack;

public class ArrayStack<T> implements IStack<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private T[] data;
	private int size;
	private int capacity;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		this.data = newElementArray(capacity);
		this.capacity = capacity;
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
	public T push(T elem) {
		if (size == capacity) {
			resize(size + 1);
		}
		data[size++] = elem;
		return elem;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T removed = data[--size];
		data[size] = null;
		shrink();
		return removed;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return data[size - 1];
	}

	@Override
	public void clear() {
		if (size > 0) {
			Arrays.fill(data, 0, size, null);
			size = 0;
		}
	}

	private void resize(int minCapacity) {
		if (minCapacity > capacity) {
			capacity = Math.max(minCapacity, capacity * 2);
			T[] new_array = newElementArray(capacity);
			System.arraycopy(data, 0, new_array, 0, size);
			data = new_array;
			
		}
	}

	private void shrink() {
		if (capacity / 2 > size) {
			int new_capacity = capacity / 2;
			T[] new_array = newElementArray(new_capacity);
			System.arraycopy(data, 0, new_array, 0, size);
			data = new_array;
			capacity = new_capacity;
		}
	}
	
	@SuppressWarnings("unchecked")
	private T[] newElementArray(int capacity) {
		return (T[]) new Object[capacity];
	}
	
}