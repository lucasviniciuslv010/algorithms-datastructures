package com.lucasvinicius.datastructures.queue.array_queue;

import java.util.Arrays;

import com.lucasvinicius.datastructures.queue.IQueue;

/**
 * Implementation of our own Queue Data Structure (Using Array)
 * 
 * <p>
 * A Queue is a linear structure which follows a particular order in which the
 * operations are performed. The order is First In First Out (FIFO). A good
 * example of a queue is any queue of consumers for a resource where the
 * consumer that came first is served first. The difference between stacks and
 * queues is in removing. In a stack we remove the item the most recently added;
 * in a queue, we remove the item the least recently added.
 * >> https://www.geeksforgeeks.org/queue-data-structure/
 * 
 * Queues, in theory, have no fixed size, but when using an array 
 * implementation this happens.
 *
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class ArrayQueue<T> implements IQueue<T> {
	
	private static final int DEFAULT_CAPACITY = 10;

	private T[] data;
	private int size;
	private int capacity;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int capacity) {
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
	public void enqueue(T elem) {
		if (size == capacity) {
			resize(size + 1);
		}
		data[size++] = elem;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		T removed = removeAt(0);
		shrink();
		return removed;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return data[0];
	}

	public T removeAt(int index) {
		checkIfTheIndexIsInUse(index);
		T removed = data[index];
		System.arraycopy(data, index + 1, data, index, size - (index + 1));
		data[--size] = null;
		shrink();
		return removed;
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
	
	private void checkIfTheIndexIsInUse(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
	}

}