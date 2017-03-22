package com.lab.quick.sort;

import java.util.Arrays;

public class Quicksort {

	public static void quickSort(int[] array, int min, int max) {

		int pivot = array[(min + max) / 2];
		int i, j;
		for (i = min, j = max; i <= j;) {
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		if (min < j)
			quickSort(array, min, j);

		if (max > i)
			quickSort(array, i, max);
	}

	public static void main(String[] args) {
		int[] array = { 6, 3, 2, -1, 0, 5, 10 };

		int min = 0;
		int max = array.length - 1;

		quickSort(array, min, max);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}