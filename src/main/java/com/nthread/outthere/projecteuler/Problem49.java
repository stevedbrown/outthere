package com.nthread.outthere.projecteuler;

public class Problem49 {

	static EraSieve sieve = new EraSieve();
	static {
		while(sieve.nextPrime()<10000){}
	};
	
	public static void main(String[] args) {
		for ( long i = 1000; i < 10000; i++ ) {
			for ( long j = 1; (2*j+i) < 10000; j++ ) {
				long ii = i + j;
				long iii = ii + j;
				
				if (!allPrime(i, ii, iii)) {
					continue;
				}
				if(NumberUtil.isPermutation(i, ii, iii) ) {
					System.out.println("..perms[" + j + "]:" + i + ", " + ii + ", " + iii
							+ ":" + i + ii + iii);
				}
			}
		}
	}
	
	public static boolean allPrime(long... nums) {
		for ( long num : nums ) {
			if (!sieve.primes.contains(num) ) {
				return false;
			}
		}
		return true;
	}

}
