package com.nthread.outthere.projecteuler;

import java.util.ArrayList;
import java.util.List;

/*
 * The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors. 
What is the first of these numbers?

 */
public class Problem47 {
	static final int FACTOR_COUNT = 4;
	public static void main(String[] args) {
		int matchcount = 0;
		List<Integer> sfactors = new ArrayList<Integer>();
		
		for ( int i = 2; true; i++ ) {
			System.out.println("i:" + i);
			List<Integer> factors = PrimeFactors.primeFactors(i);
			boolean match = false;
			for ( Integer factor : factors ) { 
				if ( sfactors.contains(factor) ) {
					match = true;
					System.out.println("...checking " + factor);
				}
			}
			
			if ( factors.size() < FACTOR_COUNT ) {
				sfactors = new ArrayList<Integer>();
				matchcount = 0;
			}
			else if ( match ) {
				sfactors = factors;
				matchcount = 1;
			}
			else {
				matchcount++;
				if ( matchcount == FACTOR_COUNT ) {
					System.out.println("match at " + i + ", start was " + (i-(FACTOR_COUNT-1)));
					return;
				}
				sfactors.addAll(factors);
			}
			
		}
	}

}
