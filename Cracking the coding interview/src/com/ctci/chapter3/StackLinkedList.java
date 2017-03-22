package com.ctci.chapter3;

import com.linkedList.practice.LinkedList;
import com.linkedList.practice.Node;

public class StackLinkedList {
	static LinkedList list, minList;

	static {
		list = new LinkedList();
		minList = new LinkedList();
		minList.insert(Integer.MAX_VALUE);
	}

	public static void push(int data) {
		list.insert(data);
		if (data <= minList.head.getData()) {
			minList.insert(data);
		}
	}

	public static void pop() {
		if (minList.head.getData() == list.head.getData()) {
			minList.head = minList.head.getNext();
		}
		if (list.head != null)
			list.deleteHead();

	}

	public static int findMin() {
		return minList.head.getData();
	}

	public static void main(String args[]) {
		push(2);
		push(3);
		push(-3);
		push(-4);
		System.out.println(findMin());
		pop();
		System.out.println(findMin());
	}
}
