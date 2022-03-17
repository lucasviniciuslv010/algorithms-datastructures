package com.lucasvinicius.datastructures.circularqueue;

import com.lucasvinicius.datastructures.circularqueue.array_circularqueue.ArrayCircularQueue;

public class CircularQueueTest {

	public static void main(String[] args) {
		
		ArrayCircularQueue<Character> queue = new ArrayCircularQueue<>(10);
		
		queue.enqueue('A');
		queue.enqueue('B');
		queue.enqueue('C');
		queue.enqueue('D');
		queue.enqueue('E');
		queue.enqueue('F');
		queue.enqueue('G');
		queue.enqueue('H');
		queue.enqueue('I');
		queue.enqueue('J');
		
		queue.dequeue();
		queue.dequeue();
		
		queue.enqueue('K');
		queue.enqueue('L');
		
		System.out.println("Peek: " + queue.peek());
		System.out.println("Size: " + queue.size());
		System.out.println("Capacity: " + queue.getCapacity());
		System.out.println("Is Full: " + queue.isFull());
		System.out.println("Is Empty: " + queue.isEmpty());
		
		System.out.println("----------------------------");
		
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}

	}

}