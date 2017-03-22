package com.ctci.chapter1.test;

import org.junit.Assert;
import org.junit.Test;
import static com.ctci.chapeter1.UniqueChars_1_1.findUniqueness;

public class UniqueChars_1_1Test {

	@Test
	public void testNegative(){
		boolean result = findUniqueness("My name is prerit");
		Assert.assertFalse(result);
	}
	
	@Test
	public void testPositive(){
		boolean result = findUniqueness("abcdefgh");
		Assert.assertTrue(result);
	}
}