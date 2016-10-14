package com.nthread.outthere.projecteuler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SievePrimeFactors {
	static EraSieve sieve = new EraSieve();
	
	public static List<Long> primeFactors(long n) {
		List<Long> factors = new ArrayList<Long>();

		for (Iterator<Long> it = sieve.iterator(); n > 1; ) {
			long candidate = it.next();
			
			if ( n % candidate == 0 ) { 
				factors.add(candidate);
				while( n % candidate == 0 ) {
					n = n / candidate;
				}
			}
		}
		return factors;
	}
}
