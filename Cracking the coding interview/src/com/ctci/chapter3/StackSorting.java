package com.ctci.chapter3;

import java.util.Stack;

public class StackSorting {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> temp = new Stack<Integer>();
	Stack<Integer> sortedStack = new Stack<Integer>();

	public void sortStack(Stack stack) {
		int tempData = (int) stack.pop();
		int tempData2;
		while (stack.isEmpty() && temp.isEmpty()) {
			
			if ((int) stack.peek() > tempData) {
				tempData = (int) stack.pop();
			}
		}
	}
}
