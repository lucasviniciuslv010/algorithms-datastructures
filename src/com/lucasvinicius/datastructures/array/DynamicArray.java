package com.lucasvinicius.datastructures.array;

import java.util.Arrays;

/**
 * Implementation of our own Dynamic Array Data Structure
 * 
 * <p>
 * An array is a collection of items stored at contiguous memory locations. 
 * The idea is to store multiple items of the same type together.
 * >> https://www.geeksforgeeks.org/array-data-structure/
 * 
 * The simple array in java cannot be used dynamically. For example. 
 * We have int[] array = new int[5]; this array can store only 5 elements,
 * its size cannot be changed in the future.
 * 
 * If you want an array which can be used dynamically you can use ArrayList in Java.
 *
 * @author Lucas Vinicius, lucasvinicius.lv010@gmail.com
 */

public class DynamicArray<T> {
	
	private static final int DEFAULT_CAPACITY = 10;

	private T[] data;
	private int size;
	private int capacity;

	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	public DynamicArray(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		this.data = newElementArray(capacity);
		this.capacity = capacity;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T get(int index) {
		checkIfTheIndexIsInUse(index);
		return data[index];
	}

	public T set(int index, T elem) {
		checkIfTheIndexIsInUse(index);
		T old = data[index];
		data[index] = elem;
		return old;
	}

	public boolean add(T elem) {
		if (size == capacity) {
			resize(size + 1);
		}
		data[size++] = elem;
		return true;
	}

	public void add(int index, T elem) {
		checkIfTheIndexIsAvailable(index);

		if (size == capacity) {
			resize(size + 1);
		}

		System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = elem;
		size++;
	}

	public T removeAt(int index) {
		checkIfTheIndexIsInUse(index);
		T removed = data[index];
		System.arraycopy(data, index + 1, data, index, size - (index + 1));
		data[--size] = null;
		shrink();
		return removed;
	}

	public boolean remove(T elem) {
		int index = indexOf(elem);

		if (index < 0) {
			return false;
		}

		removeAt(index);
		return true;
	}
	
	public int indexOf(T elem) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(elem)) {
				return i;
			}
		}
		return -1;
	}

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

	private void checkIfTheIndexIsAvailable(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for (int i = 0; i < size - 1; i++) {
			sb.append(data[i]);
			sb.append(", ");
		}

		if (size > 0) {
			sb.append(data[size - 1]);
		}

		sb.append("]");

		return sb.toString();
	}
	
}