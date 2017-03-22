package com.lab.bucket.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class BuckSort {
	static int[] array = { 6, 3, 2, 0, 5, 10, 19, 28 };
	public static ArrayList<LinkedList> linkedListArray;

	public static int findMax() {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static void createBuckets(int size) {
		linkedListArray = new ArrayList<LinkedList>(size);
		for (int index = 0; index < size; index++) {
			linkedListArray.add(new LinkedList());
		}
	}

	public static void insertIntoBucket() {
		for (int i = 0; i < array.length; i++) {
			int bucketIndex = array[i] / 10;
			linkedListArray.get(bucketIndex).add(array[i]);
		}

	}

	public static void sortBucketsAndPrint() {
		Iterator it = linkedListArray.iterator();
		while (it.hasNext()) {
			LinkedList lList = (LinkedList) it.next();
			Collections.sort(lList);
			Iterator it2 = lList.iterator();
			while (it2.hasNext()) {
				System.out.println(it2.next());
			}
		}
	}

	public static void main(String args[]) {
		int max = findMax();
		int no_buckets = max / 10 + 1;
		createBuckets(no_buckets);
		insertIntoBucket();
		sortBucketsAndPrint();

	}
}
