package com.lucasvinicius.datastructures.array;

public class DynamicArrayTest {

	public static void main(String[] args) {

		DynamicArray<Character> array = new DynamicArray<>(5);

		array.add('A');
		array.add('B');
		array.add('C');
		array.add('D');
		array.add('E');
		array.add('F');
		array.add('G');
		array.add('H');
		array.add('I');
		array.add('J');
		array.add('K');
		array.add('L');

		array.removeAt(11);
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");
		
		array.add(3, 'd');
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");

		array.removeAt(3);
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");

		array.remove('F');
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");

		array.clear();
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");

		array.add('A');
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");

		array.removeAt(0);
		System.out.println(array);
		System.out.println("size: " + array.size());
		System.out.println("\n-----------------------------\n");

	}

}