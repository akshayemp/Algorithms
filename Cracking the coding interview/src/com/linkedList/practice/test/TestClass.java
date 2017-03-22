package com.linkedList.practice.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.linkedList.practice.LinkedList;
import com.linkedList.practice.Node;

public class TestClass {

	private LinkedList l = new LinkedList();

	@Before
	public void init() {

		System.out.println("++++++Creating Linked List++++++");
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insert(6);

	}

	@Test
	public void createUnconnectedNodesTest() {
		LinkedList l1 = new LinkedList();
		l1.createUnconnectedNodes(1);
		l1.createUnconnectedNodes(2);
		l1.createUnconnectedNodes(3);
	}

	@Test
	public void insertTest() {
		LinkedList l = new LinkedList();
		System.out.println("++++++Insert++++++");
		l.insert(4);
		l.insert(5);
		l.insert(6);
	}

	@Test(expected = RuntimeException.class)
	public void deleteHeadTest() {
		System.out.println("++++++Delete Head++++++");

		System.out.println(l.deleteHead());
		System.out.println(l.deleteHead());
		System.out.println(l.deleteHead());
		System.out.println(l.deleteHead());// Runtime Exception should occur
		System.out.println(l.deleteHead());
		System.out.println(l.deleteHead());
		System.out.println(l.deleteHead());
	}

	@Test
	public void deleteTest() {

		System.out.println("++++++Delete++++++");
		System.out.println(l.delete(3));
		System.out.println(l.delete(5));
	}

	@Test
	public void reverseTest() {
		l.reverse();
	}

	@Test
	public void traverseTest() {
		l.traverse();
	}
	
	@Test
	public void findnToLastTest(){
		Node n = l.findnToLast(3);
		System.out.println("++++The Nth eleement from last is ");
		System.out.println(n.getData());
	}
	
	@Test
	@Ignore
	public void partitionTest(){
		System.out.println("++++++Creating Linked List++++++");
		LinkedList l1 = new LinkedList();
		l1.insert(3);
		l1.insert(5);
		l1.insert(1);
		l1.insert(6);
		l1.insert(2);
		l1.insert(0);
		
		l1.partition(1);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void deleteAtPositionTest(){
		LinkedList l1 = new LinkedList();
		l1.insert(3);
		l1.insert(5);
		l1.insert(1);
		l1.insert(6);
		l1.insert(2);
		l1.insert(0);
		
		Node n = l1.search(3);
		l1.deleteAtPosition(n);
		l1.deleteAtPosition(null); //runtime Exception
	}
	
	@Test
	public void addNumbersTest(){
		System.out.println("/n++++Add Numbers Test +++++");
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList l0 = new LinkedList();
		l1.insert(9);
		l1.insert(1);
		l1.insert(9);
		l2.insert(1);
		l2.insert(9);
		l2.insert(5);
		
		l0.addNumbers(l1, l2);
		
	}
	
	@Test
	public void loopInList(){
		
	}

}
