package com.ctci.chapter3;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack<Integer>> setOfStacks = new ArrayList<Stack<Integer>>();
	int size = 3;
	private Stack stack;

	public void push(int data) {
		if (setOfStacks.size() != 0) {
			Stack last = getLast();
			if (last.size() < size) {
				last.push(data);
			} else {
				addAnotherStack(data);
			}
		} else {
			addAnotherStack(data);
		}
	}

	public void addAnotherStack(int data) {
		stack = new Stack();
		stack.push(data);
		setOfStacks.add(stack);
	}

	public void pop() {
		Stack last = getLast();
		if (last != null) {
			if (last.size() == 1) {
				setOfStacks.remove(setOfStacks.size() - 1);
			} else {
				getLast().pop();
			}
		}
	}

	public Stack getLast() {
		return setOfStacks.get(setOfStacks.size() - 1);
	}

	public int peek() {
		Stack last = getLast();
		return (int) last.peek();

	}

}
