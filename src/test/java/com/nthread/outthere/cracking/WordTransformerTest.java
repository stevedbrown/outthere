package com.nthread.outthere.cracking;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordTransformerTest {
	WordTransformer transformer = new WordTransformer();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(Arrays.asList("DAMP", "DAME", "DIME", "DIKE", "LIKE"), transformer.path("DAMP", "LIKE"));
		assertEquals(Arrays.asList("BRAT", "BLAT", "BLAE", "ALAE", "ALAS", "ALTS", "ALTO", "AUTO"), transformer.path("BRAT", "AUTO"));
	}

}
    