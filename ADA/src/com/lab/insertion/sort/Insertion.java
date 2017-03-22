package com.lab.insertion.sort;

import java.util.Scanner;

public class Insertion {
	public static int[] array;
	
	public Insertion(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int  size = scanner.nextInt();
		array = new int[size];
		System.out.println("Enter the array to be sorted: ");
		for (int i = 0; i<size;i++){
			array[i] = scanner.nextInt();
		}
		
	}
	
	public static void main(String... args){
		Insertion iSort = new Insertion();
		array = insertionSort(iSort.array);
		for(int i = 0 ; i< array.length; i++)
		System.out.println(array[i]);
	}
	
	public static int[] insertionSort(int[] array){
		int key = array[0];
		for(int i = 1; i<=array.length-1; i++){
			for(int j = i; j>0 && array[j-1] > array[j]; j--){
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
				
			}
		}
		
		return array;
	}

}
