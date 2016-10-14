package com.nthread.outthere.cracking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListPalindromeTest {

	ListPalindrome checker = new ListPalindrome();

	@Test
	public void testPal() {
		assertTrue(checker.isPalindrome(Arrays.asList(1, 0, 6, 0, 1)));
		assertFalse(checker.isPalindrome(Arrays.asList(1, 0, 6, 0, 2)));
		assertTrue(checker.isPalindrome(Arrays.asList(1, 0, 6, 6, 0, 1)));
		assertFalse(checker.isPalindrome(Arrays.asList(1, 0, 6, 7, 0, 2)));
	}
	
}
