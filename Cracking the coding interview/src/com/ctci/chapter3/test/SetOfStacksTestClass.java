package com.ctci.chapter3.test;

import org.junit.Test;

import com.ctci.chapter3.SetOfStacks;

import junit.framework.Assert;

public class SetOfStacksTestClass {
	@Test
	public void pushTest(){
		SetOfStacks sos = new SetOfStacks();
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		Assert.assertEquals(sos.peek(), 4) ;
		sos.pop();
		Assert.assertEquals(sos.peek(), 3) ;
		sos.pop();
		Assert.assertEquals(sos.peek(), 2) ;
	}
}
