package com.lucasvinicius.datastructures.queue;

import com.lucasvinicius.datastructures.queue.array_queue.ArrayQueue;

public class QueueTest {
	
	public static void main(String[] args) {
		
		IQueue<Character> queue = new ArrayQueue<>();
		
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
		
		System.out.println("Peek: " + queue.peek());
		System.out.println("Is Empty: " + queue.isEmpty());
		
		System.out.println("----------------------------");
		
		while(!queue.isEmpty()) {
			System.out.print(queue.dequeue() + " ");
		}
		
	}

}