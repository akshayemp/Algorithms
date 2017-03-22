package com.ctci.chapter3.test;

import org.junit.Test;

import com.ctci.chapter3.TwoStackQueue;

public class TwoStackQueueTest {
	@Test
	public void pushTest(){
		TwoStackQueue queue = new TwoStackQueue(3);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);
		queue.pop();
	}
}
