package com.nthread.outthere.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class EraSieveTest {

	@Test
	public void testNextPrime() {
		EraSieve sieve = new EraSieve();
		assertEquals(2, sieve.nextPrime());
		assertEquals(3, sieve.nextPrime());
		assertEquals(5, sieve.nextPrime());
		assertEquals(7, sieve.nextPrime());
		assertEquals(11, sieve.nextPrime());
		assertEquals(13, sieve.nextPrime());
		assertEquals(17, sieve.nextPrime());
		assertEquals(19, sieve.nextPrime());
	}

}
