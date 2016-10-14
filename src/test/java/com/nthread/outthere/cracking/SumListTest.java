package com.nthread.outthere.cracking;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SumListTest {

	SumList summer = new SumList();

	@Test
	public void testReverseSum1() {
		List<Integer> one = Arrays.asList(6, 1, 7);
		List<Integer> two = Arrays.asList(2, 9, 5);
		List<Integer> out = Arrays.asList(9, 1, 2);
	
		assertEquals(out, summer.reverseSum(one, two));
	}

	@Test
	public void testReverseSum2() {
		List<Integer> one = Arrays.asList(1, 1, 1);
		List<Integer> two = Arrays.asList(1, 1);
		List<Integer> out = Arrays.asList(1, 2, 2);
	
		assertEquals(out, summer.reverseSum(one, two));
	}
	
	@Test
	public void testReverseSum3() {
		List<Integer> one = Arrays.asList(5, 0);
		List<Integer> two = Arrays.asList(6, 0);
		List<Integer> out = Arrays.asList(1, 1, 0);
	
		assertEquals(out, summer.reverseSum(one, two));
	}
	
}
