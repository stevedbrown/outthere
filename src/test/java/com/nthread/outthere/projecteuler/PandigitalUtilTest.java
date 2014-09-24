package com.nthread.outthere.projecteuler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PandigitalUtilTest {

	@Test
	public void testGetPandigitals() {
		Tester<String> tester = new Tester<String>() {
			@Override
			public boolean test(String t) {
				return t.startsWith("1234");
			}			
		};
		
		List<String> pans = PandigitalUtil.getPandigitals(tester);
		assertEquals(720, pans.size());
	}
	
	@Test
	public void testAddPandigitals() {
		List<String> pans = new ArrayList<String>();
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		Tester<String> tester = new Tester<String>() {
			@Override
			public boolean test(String t) {
				return t.startsWith("3");
			}			
		};
		
		PandigitalUtil.addPandigitals(pans, "", nums, tester);
		assertEquals(2, pans.size());
		assertTrue(pans.contains("312"));
		assertTrue(pans.contains("321"));
	}

}
