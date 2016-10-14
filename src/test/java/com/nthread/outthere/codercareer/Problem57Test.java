package com.nthread.outthere.codercareer;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem57Test {

	@Test
	public void testFindIndex() {
		int index = Problem57.findIndex(new int[]{-3, -1, 1, 3, 5});
		assertEquals(3, index);
		
		index = Problem57.findIndex(new int[]{-3, -1, 1, 4, 5});
		assertEquals(-1, index);
	}

}
