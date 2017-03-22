package com.ctci.chapter3;

import java.util.Stack;

/**
 * Implementation of Queue using 2 stacks.
 * 
 * @author Prerit
 *
 */
public class TwoStackQueue {
	private Stack stackBegin = new Stack();
	private Stack stackEnd = new Stack();
	private int capacity;
	
	public TwoStackQueue(int capacity){
		this.capacity = capacity;
	}

	public void push(int item) {
		if (stackBegin.size() + stackEnd.size() == 2 * capacity) {
			System.err.print("Queue is full!, please pop to add more.");
			return;
		}
		if (stackEnd.size() == capacity) {
			shuffle(stackEnd, stackBegin);
			stackEnd.push(item);
		} else {
			stackEnd.push(item);
		}
		
	}

	public void pop() {
		if (stackBegin.size() != 0) {
			stackBegin.pop();
		} else {
			shuffle(stackEnd, stackBegin);
			stackBegin.pop();
		}
	}

	public void shuffle(Stack stackEnd, Stack stackBegin) {
		while (!stackEnd.isEmpty() && stackBegin.size() != capacity) {
			stackBegin.push(stackEnd.pop());
		}
	}
}
