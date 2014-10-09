package com.nthread.outthere.projecteuler;

import java.util.ArrayList;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be 
 * written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a 
prime and twice a square?

 * @author stephenbrown
 *
 */
public class Problem46 {
	
	public static void main(String[] args) {
		EraSieve sieve = new EraSieve();
		long lastPrime = 1;
		
		long last2Sqr = 0;
		long last2Base = 0;
		ArrayList<Long> squareBy2 = new ArrayList<Long>();
		
		for (int i = 1; true; i+=2) {
			while(lastPrime < i ) 
				lastPrime = sieve.nextPrime();
			
			if (i == lastPrime) {
				System.out.println(i + ":was prime");
				continue;
			}
			while ( last2Sqr < i ) {
				last2Base++;
				last2Sqr = 2 * last2Base * last2Base;
				squareBy2.add(last2Sqr);
			}
			
			System.out.println(i + ":not prime");
			long x;
			boolean found = false;
			for ( long prime : sieve.primes ) {
				for ( long square2 : squareBy2 ) {
					if((prime + square2) == i) {
						found = true;
						System.out.println("..." + prime + ", " + square2);
						break;
					}
					if((prime + square2) > i) {
						break;
					}
				}
				if ( found ) {
					break;
				}
			}
			if (!found) {
				System.out.println("...not found");
				return;
			}
		}
	}

}
