package com.nthread.outthere.cracking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListReverserTest {

	ListReverser reverser = new ListReverser();

	@Test
	public void testPal() {
		assertEquals(Arrays.asList(1,2,3), reverser.reverse(Arrays.asList(3,2,1)));
	}
	
}
