package com.lab.bucket.sort;

public class BucketSort {
	public static void main(String... args) {
		int[] array = { 6, 3, 2, 0, 5, 10, 6, -1 };
		bucketSort(array);
	}

	public static void bucketSort(int[] array) {
		int x = findmax(array);
		int[] bucket = new int[x + 1];
		int[] negbucket = new int[x + 1];

		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0)
				bucket[array[i]]++;
			else if (array[i] < 0)
				negbucket[(-1) * array[i]]++;
		}

		for (int j = negbucket.length - 1; j >= 0; j--) {
			for (int z = 0; z < negbucket[j]; z++) {
				System.out.println((-1) * j);
			}
		}

		for (int j = 0; j < bucket.length; j++) {
			for (int z = 0; z < bucket[j]; z++) {
				System.out.println(j);
			}
		}
	}

	public static int findmax(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
}
