package com.lab.merge.sort;

import java.util.Scanner;

public class MergeSort {

	public static int[] array;
	public static int[] temp;

	public MergeSort(int[] array) {
		this.array = array;
		this.temp = new int[array.length];
	}

	public static void main(String... args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int size = scanner.nextInt();
		array = new int[size];
		System.out.println("Enter the array to be sorted: ");
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		MergeSort mSort = new MergeSort(array);
		mSort.mergeSort(0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public void mergeSort(int begin, int end) {
		int mid = 0;
		if (begin < end) {
			mid = (begin + end) / 2;
			mergeSort(begin, mid);
			mergeSort(mid + 1, end);
			merge(begin, mid, end);
		}

	}

	public static void merge(int begin, int mid, int end) {

		int p = begin;
		int q = mid+1;
		int r = begin;
		for (int i = begin; i <= end; i++) {
			temp[i] = array[i];
		}
		while (p <= mid && q <= end) {
			if (array[p] <= array[q]) {
				array[r++] = temp[p++];

			} else {
				array[r++] = array[q++];
			}
			
		}
		while(p<=mid){
			array[r++] = temp[p++];
		}
	}
}
