package com.lucasvinicius.datastructures.stack;

import java.util.Scanner;

import com.lucasvinicius.datastructures.stack.array_stack.ArrayStack;

public class StackTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		IStack<Integer> stack = new ArrayStack<Integer>();
		
		System.out.print("Enter an integer: ");
		int number = sc.nextInt();
	
		int aux    = number;
		
		while(aux != 0) {
			int rest = aux % 2;
			stack.push(rest);
			aux /= 2;
		}
		
		String binary = "";
		
		while (!stack.isEmpty()) {
			binary += stack.pop();
		}
		
		System.out.println(number + " (decimal) = " + binary + " (binary)");
		
		sc.close();
	
	}

}