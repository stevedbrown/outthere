package com.nthread.outthere.codeeval;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(args[0]), Charset.defaultCharset());
		
		for(String line : lines ) { 
			printFizzBuss(line);
		}
	}

	private static void printFizzBuss(String line) {
		String[] vals = line.split(" ");
		int one = Integer.parseInt(vals[0]);
		int two = Integer.parseInt(vals[1]);
		int three = Integer.parseInt(vals[2]);
		
		for ( int i = 1; i <= three; i++ ) { 
			if ( i > 1 ) 
				System.out.print(" ");
			if ( i % (one * two) == 0 ) { 
				System.out.print("FB");
			}
			else if ( i % one == 0 ) {
				System.out.print("F");
			}
			else if ( i % two == 0 ) {
				System.out.print("B");
			}
			else
				System.out.print(i);
		}
		System.out.println();
	}
}
