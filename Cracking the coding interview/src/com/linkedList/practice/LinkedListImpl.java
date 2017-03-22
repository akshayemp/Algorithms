package com.linkedList.practice;

public interface LinkedListImpl {
	public Node createUnconnectedNodes(int data);
	public void insert(int data);
	public int deleteHead();
	public int delete(int data);
	public void traverse();
	public void traverse(LinkedList list);
	public void append(int data);
	public void prepend(int data);
	public void reverse();
	/**
	 * To remove duplicate elements from an unsorted linked list using a buffer.
	 */
	public void removeDuplicates();
	/**
	 * To remove duplicate elements form an unsorted linked list without using a buffer.
	 */
	public void removeDuplicatesEfficient();
	/**
	 * TO find nth to last element in singly linked list.
	 */
	public Node findnToLast(int n);
	public int size(LinkedList list);
	public Node search(int data);
	public void partition(int data);
	public void deleteAtPosition(Node n);
	public void addNumbers(LinkedList l1, LinkedList l2);
	public void loopInList();
	public void circularInsert(int data, boolean loop);
	
	
	
}
