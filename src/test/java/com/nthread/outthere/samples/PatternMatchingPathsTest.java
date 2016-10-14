package com.nthread.outthere.samples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class PatternMatchingPathsTest {
	public static final String TEST_DIR = "/Users/stephenbrown/code/outthere/src/main/java/com/nthread/outthere/samples/";
	public static final Charset ENCODING = StandardCharsets.UTF_8;

	@Test
	public void testWarbyFile() throws IOException {
		Path inPath = Paths.get(TEST_DIR + "wb1.txt");
		Path outPath = Paths.get(TEST_DIR + "wb1_out.txt");
		processContents(inPath, outPath);
	}
	
	@Test
	public void testMyFile() throws IOException {
		Path inPath = Paths.get(TEST_DIR + "alt.txt");
		Path outPath = Paths.get(TEST_DIR + "alt_out.txt");
		processContents(inPath, outPath);
	}
	
	public void processContents(Path inPath, Path outPath) throws IOException {
		
		List<String> input = Files.readAllLines(inPath, ENCODING);
		assertNotNull(input);
		
		List<String> expected = Files.readAllLines(outPath, ENCODING);
		assertNotNull(expected);
		
		List<String> output = PatternMatchingPaths.processInput(input);
		assertNotNull(output);
		
		assertEquals(expected, output);
		
	}

}
