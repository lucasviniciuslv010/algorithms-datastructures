package com.lucasvinicius.datastructures.circularqueue.array_circularqueue;

import java.util.Arrays;

import com.lucasvinicius.datastructures.circularqueue.ICircularQueue;

/**
 * Implementation of our own Circular Queue Data Structure (Using Array)
 * 
 * <p>
 * Circular Queue is a linear data structure in which the operations are
 * performed based on FIFO (First In First Out) principle and the last position
 * is connected back to the first position to make a circle. It is also called ‘Ring Buffer’.
 * >> https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
 * 
 * In a normal Queue, we can insert elements until queue becomes full. But once
 * queue becomes full, we can not insert the next element even if there is a
 * space in front of queue.
 * 
 * In the Circular Queue, the last position is connected back to the first
 * position to make a circle.
 *
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

@SuppressWarnings("unchecked")
public class ArrayCircularQueue<T> implements ICircularQueue<T> {
	
	private static final int DEFAULT_CAPACITY = 10; 

	private T[] data;
	private int size;
	private int capacity;
	
	private int front;
	private int rear;

	public ArrayCircularQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayCircularQueue(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		this.data = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	@Override
	public int size() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}
	
	@Override
	public void enqueue(T elem) {
		if (isFull()) {
			throw new RuntimeException("Queue is full");
		}
		data[rear] = elem;
		rear = (rear + 1) % capacity;
		size++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		T elem = data[front];
		data[front] = null;
		front = (front + 1) % capacity;
		size--;
		return elem;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return data[front];
	}

	@Override
	public void clear() {
		if (size > 0) {
			Arrays.fill(data, 0, size, null);
			size = 0;
		}
	}

}