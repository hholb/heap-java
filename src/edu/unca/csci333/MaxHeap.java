/*
 * Hayden Holbrook
 * CSCI-333 Fall 2023
 * Homework 2 - Heap
 */

package edu.unca.csci333;

/**
 * An implementation of a max-heap along with heap-sort.
 *
 * @author Hayden Holbrook <hholbroo@unca.edu>
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {
	private T[] heap;
	private int heapsize;

	/**
	 * Constructs a max-heap from the given array.
	 *
	 * @param arr - array of Comparable objects that will be elements in the heap.
	 */
	public MaxHeap(T[] arr) {
		this.heapsize = arr.length;
		this.heap = arr;
		this.buildMaxHeap();
	}

	/**
	 * Returns the index of "left-child" of the element at the given index.
	 * 
	 * @param i index to find left-child of
	 * @return index of left-child of i
	 */
	private int leftChildOf(int i) {
	    int result = (2 * i) + 1;
	    if (result >= this.heapsize)
	        return -1;
	    else
	        return result;
	}

	/**
	 * Returns the index of "right-child" of the element at the given index.
	 * 
	 * @param i index to find right-child of
	 * @return index of right-child of i
	 */
	private int rightChildOf(int i) {
	    int result = (2 * i) + 2;
	    if (result >= this.heapsize)
	        return -1;
	    else
	        return result;
	}


	/**
	 * Prints the contents of the heap to standard output.
	 */
	public void printMaxHeap() {
		System.out.println("Heap size: " + this.heapsize);
		String arr = "{";
		for (int i = 0; i < this.heapsize; i++) {
			if (i != heapsize - 1)
				arr = arr + this.heap[i] + ", ";
			else
				arr = arr + this.heap[i] + "}";
		}
		System.out.println(arr);
	}

	/**
	 * Restores the max-heap property starting at the given index.
	 * @param i index to begin heapifying.
	 */
	private void maxHeapify(int i) {
	    int left = leftChildOf(i);
	    int right = rightChildOf(i);
	    int largest = i;
	    
	    if (left != -1 && heap[left].compareTo(heap[largest]) > 0) {
	        largest = left;
	    }
	    
	    if (right != -1 && heap[right].compareTo(heap[largest]) > 0) {
	        largest = right;
	    }
	    
	    if (largest != i) {
	        T tmp = heap[i];
	        heap[i] = heap[largest];
	        heap[largest] = tmp;
	        this.maxHeapify(largest);
	    }
	}

	/**
	 * Creates a max-heap from the internally stored array.
	 */
	private void buildMaxHeap() {
		for (int i = this.heapsize / 2; i >= 0; i--) {
			this.maxHeapify(i);
		}
	}

	/**
	 * Sorts the internally stored heap.
	 */
	public void heapsort() {
		int backupHeapSize = this.heapsize;
		this.buildMaxHeap();

	    for (int i = this.heapsize - 1; i >= 1; i--) {
	        // Swap the root with the last element
	        T tmp = this.heap[0];
	        this.heap[0] = this.heap[i];
	        this.heap[i] = tmp;

	        // Shrink the heap
	        this.heapsize--;

	        // Repair the heap
	        this.maxHeapify(0);
	    }
	    
	    // Restore heapsize from backup
	    this.heapsize = backupHeapSize;
	}
}
