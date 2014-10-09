package com.nthread.outthere.projecteuler;

/**
 * The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, 
contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive 
primes?

 * @author stephenbrown
 *
 */
public class Problem50 {
	public static final long MAX = 1000000;

	static EraSieve sieve = new EraSieve();
	static {
		while(sieve.nextPrime()<MAX){}
	};
	static int primeCount = sieve.primes.size();
	
	public static void main(String[] args) {
		int longestFound = 0;
		for ( int i = 0; i < primeCount-1; i++ ) {
			for ( int j = i+1; j < primeCount; j++ ) {
				if ( (j - i ) < longestFound ) {
					continue;
				}
				long num = 0; 
				for ( int k = i; k <= j; k++ ) {
					num += sieve.primes.get(k);
				}
				//System.out.println(i + ":" + j + "==>" + num);
				if ( sieve.primes.contains(num) ) {
					longestFound = (j-i+1);
					System.out.println(num + " with length " + longestFound );
				}
			}
		}
	}

}
