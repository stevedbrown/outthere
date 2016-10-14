package com.nthread.outthere.projecteuler;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SievePrimeFactorsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrimeFactors() {
		List<Long> factors = SievePrimeFactors.primeFactors(504);
		assertEquals(Arrays.asList(new Long[]{2l,3l,7l}), factors);
	}

}
