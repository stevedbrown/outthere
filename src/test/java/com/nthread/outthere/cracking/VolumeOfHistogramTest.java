package com.nthread.outthere.cracking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VolumeOfHistogramTest {
	VolumeOfHistogram calc = new VolumeOfHistogram();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVolume1() {
		assertEquals(26, calc.volumeOf(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0));
	}

	@Test
	public void testVolume2() {
		assertEquals(4*2+6*3+3+5*2+3+1+3, calc.volumeOf(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0));
	}

}
