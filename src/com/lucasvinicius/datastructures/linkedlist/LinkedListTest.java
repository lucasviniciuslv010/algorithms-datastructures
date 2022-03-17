package com.lucasvinicius.datastructures.linkedlist;

import java.util.Scanner;

import com.lucasvinicius.datastructures.linkedlist.doubly.DoublyLinkedList;
import com.lucasvinicius.datastructures.linkedlist.singly.SinglyLinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - SinglyLinkedList");
		System.out.println("2 - DoublyLinkedList");
		System.out.print("Choose which data structure you want to use (1/2): ");
		char ch = sc.next().charAt(0);
		
		ILinkedList<Character> linkedlist = (ch == '1')? 
				new SinglyLinkedList<>() : new DoublyLinkedList<>();
		
		System.out.println("\n-----------------------------\n");
		
		linkedlist.add('A');
		linkedlist.add('B');
		linkedlist.add('C');
		linkedlist.add('D');
		linkedlist.add('E');
		linkedlist.add('F');
		linkedlist.add('G');
		linkedlist.add('H');
		linkedlist.add('I');
		linkedlist.add('J');
		linkedlist.add('K');
		linkedlist.add('L');
		
		linkedlist.addAt(3, 'd');
		System.out.println(linkedlist);
		System.out.println("size: " + linkedlist.size());
		System.out.println("\n-----------------------------\n");
		
		linkedlist.removeAt(3);
		System.out.println(linkedlist);
		System.out.println("size: " + linkedlist.size());
		System.out.println("\n-----------------------------\n");
		
		linkedlist.remove('F');
		System.out.println(linkedlist);
		System.out.println("size: " + linkedlist.size());
		System.out.println("\n-----------------------------\n");
		
		linkedlist.clear();
		System.out.println(linkedlist);
		System.out.println("size: " + linkedlist.size());
		System.out.println("\n-----------------------------\n");
		
		linkedlist.add('A');
		System.out.println(linkedlist);
		System.out.println("size: " + linkedlist.size());
		System.out.println("\n-----------------------------\n");
		
		linkedlist.removeAt(0);
		System.out.println(linkedlist);
		System.out.println("size: " + linkedlist.size());
		System.out.println("\n-----------------------------\n");
		
		sc.close();
		
	}

}