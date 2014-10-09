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

}
