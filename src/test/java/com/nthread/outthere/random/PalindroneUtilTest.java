package com.nthread.outthere.random;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindroneUtilTest {

	@Test
	public void testIsPalindrone() {
		assertTrue(PalindroneUtil.isPalindrone("anna"));
		assertTrue(PalindroneUtil.isPalindrone("madamimadam"));
		assertFalse(PalindroneUtil.isPalindrone("fred"));
		assertFalse(PalindroneUtil.isPalindrone("one"));		
	}

}
