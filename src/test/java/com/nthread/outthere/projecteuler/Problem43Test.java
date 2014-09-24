package com.nthread.outthere.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem43Test {

	@Test
	public void testFour3Divisible() {
		assertTrue(Problem43.four3Divisible("1406357289"));
		assertFalse(Problem43.four3Divisible("1406357298"));
	}

}
