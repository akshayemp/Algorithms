package com.ctci.chapter3;

/**
 * This code will demonstrate the use of array for implemationg 3 stacks.
 * 
 * @author prerit
 *
 */
public class ThreeStacks {
	static final int size = 9;
	static int[] topPointer = { 0, 0, 0 };
	static int[] threeStack = new int[size];

	public static void push(int stackNum, int data) {
		int top = topPointer[stackNum - 1] == 0 ? stackNum * (size / 3) + topPointer[stackNum - 1] - 1
				: topPointer[stackNum - 1] - 1;
		threeStack[top] = data;
		topPointer[stackNum - 1] = top;

	}

	public static void pop(int stackNum) {
		topPointer[stackNum - 1]++;
	}

	public static int peek(int stackNum) {
		return threeStack[topPointer[stackNum - 1]];
	}
}
