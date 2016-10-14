package com.nthread.outthere.cracking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PatternMatchingTest {

	PatternMatching matcher = new PatternMatching();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatches() {
		assertTrue(matcher.matches("catcatgocatgo", "aabab"));
		assertFalse(matcher.matches("catcatgocatgo", "aababbb"));
		assertTrue(matcher.matches("catcatgocatgo", "ba"));
	//	assertTrue(matcher.matches("catcatgocatgo", "aaba"));
		assertTrue(matcher.matches("catcatgocatgo", "a"));
		assertTrue(matcher.matches("catcatgocatgo", "ab"));
	}

	@Test
	public void testDoesMatch() {
		assertTrue(matcher.doesMatch("catcatgocatgo", "aabab"));
		assertFalse(matcher.doesMatch("catcatgocatgo", "aababbb"));
		assertTrue(matcher.doesMatch("catcatgocatgo", "ba"));
		//assertTrue(matcher.doesMatch("catcatgocatgo", "aaba"));
//		assertTrue(matcher.doesMatch("catcatgocatgo", "a"));
		assertTrue(matcher.doesMatch("catcatgocatgo", "ba"));
	}

}
