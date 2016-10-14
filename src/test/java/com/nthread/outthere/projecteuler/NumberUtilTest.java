package com.nthread.outthere.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberUtilTest {

	@Test
	public void testIsPermutations() {
		assertTrue(NumberUtil.isPermutation(1487, 4817, 8147));
		assertFalse(NumberUtil.isPermutation(1487, 4817, 8145));
		assertFalse(NumberUtil.isPermutation(1487, 4812, 8147));
	}
	
	@Test
	public void testGcd() {
		assertEquals(1l, NumberUtil.gcd(2l*3l, 5l*7l));
		assertEquals(7l, NumberUtil.gcd(2l*7l, 5l*7l));
		System.out.printf("%s==%s\n", 1l, NumberUtil.gcd(5l,  27l));
		assertEquals(1l, NumberUtil.gcd(5l, 27l));
		assertEquals(1l, NumberUtil.gcd(5l, 32l));
		assertEquals(1l, NumberUtil.gcd(27l, 32l));
	}

}
