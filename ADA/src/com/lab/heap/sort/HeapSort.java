package com.lab.heap.sort;

public class HeapSort {
	
	
	public static int n;
	
	public static void main(String args[]) {
		int[] array = { 5, 3, 7, 2, 19, 20, 56 , 98, 0 };
		n = array.length;
		build_max_heap(array);
		for (int i = n; i > 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			n= n-1;
			max_heapify(array,0);			
		}
		for(int i = 0; i<array.length;i++)
			System.out.println(array[i]);
	}
	
	public static void build_max_heap(int[] array){
		n = array.length-1;
		for(int i = n/2; i>=0;i--){
			max_heapify(array,i);
		}	
	}
	
	public static void max_heapify(int[] array, int i){
		int l = 2 * i;
		int r = 2 * i + 1;
		int largest = i;
		if(l<=n && array[l] > array[i]){
			largest = l;
		}
		if(r<=n && array[r]> array[largest]){
			largest = r;
		}
		int temp;
		if(largest != i){
			temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			max_heapify(array,largest);
		}
		
	}
}