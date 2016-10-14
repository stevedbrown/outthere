package com.nthread.outthere.samples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This class takes System.in input in the form of an (assumed) int, a list of patterns of that length, then an 
 * int, and a list of paths matching that int. 
 * 
 * The output from this class will be a list of best pattern matches for the input paths - matched from the input patterns.
 * @author stephenbrown
 *
 */
public class PatternMatchingPaths {
	private static final String NO_ANS = "NO MATCH";
	
	public static void main(String[] args) throws IOException {
		// Check for input.
		if (System.in.available() == 0) { 
			System.err.println("PatternMathingPaths requires an input file");
			return;
		}
		
		List<String> input = new ArrayList<String>();
        
        for(Scanner scanner = new Scanner(System.in); scanner.hasNext(); ) {
         	input.add(scanner.next());
        }
        
        // The meat of this method, calls the helper method, processInput
        List<String> result = processInput(input);
        
        // Could have used a helper lib for this, but no reason to bring in a helper lib for something so small
        for(String line : result ) {
        	System.out.println(line);
        }
	}


	protected static List<String> processInput(List<String> input) {
		// Check for null and minimum input size
		if ( input == null || input.size() < 2 ) { 
			System.out.println("The input was too small.");
			return null;
		}
		
		// Check make sure there are enough input patterns to match the number specified
		int numPatterns = Integer.parseInt(input.get(0));
		if ( input.size() < numPatterns + 1 ) { 
			System.out.println("There weren't enough patterns specified.");
			return null;
		}
		
		// Check that there are enough input paths to match the number specified
		int numPaths = Integer.parseInt(input.get(numPatterns+1));
		if ( input.size() < numPaths + 1 ) { 
			System.out.println("There weren't enough paths specified.");
			return null;
		}
		
		// Create the root node of the pattern tree that will be used to match paths.
		PatternNode root = new PatternNode();
		
		// Iterate through the patterns, add them to the pattern tree
		for (int i = 0; i < numPatterns; i++ ) {
			String pattern = input.get(i+1);
			root.addPattern(pattern);
		}
		
		List<String> answers = new ArrayList<String>();
		
		// Iterate through that paths, look for matches in the pattern tree, add the matches to the answers list
		for (int i = 0; i < numPaths; i++ ) {
			String path = input.get(i+numPatterns+2);
			String ans = root.findPath(path);
			answers.add(ans == null ? NO_ANS : ans);
		}
		
		return answers;
	}
}
