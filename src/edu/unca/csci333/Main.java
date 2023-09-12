/*
 * Hayden Holbrook
 * CSCI-333 Fall 2023
 * Homework 2 - Heap
 */
package edu.unca.csci333;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		final int arraySize = 10;
		
		for (int i = 0; i < 5; i++) {
			// Build array
			Random rand = new Random();
			Integer[] arr = new Integer[arraySize];
			for (int n = 0; n < arraySize; n++) {
				arr[n] = rand.nextInt();
			}
			
			// Run tests
			System.out.printf("===== TEST ARRAY %d =====\n", i + 1);;
			System.out.println("Original Array:");
			System.out.println(java.util.Arrays.toString(arr) + "\n");
			MaxHeap h = new MaxHeap(arr);
			System.out.println("After the Heapening:");
			h.printMaxHeap();
			System.out.println();
			h.heapsort();
			System.out.println("After the heapsort:");
			h.printMaxHeap();
			System.out.println();
		}
	}

}
