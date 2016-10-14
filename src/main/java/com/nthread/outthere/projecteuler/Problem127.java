package com.nthread.outthere.projecteuler;

import java.util.Arrays;
import java.util.List;

/**
 * The radical of n, rad(n), is the product of distinct prime factors of n. For example, 504 = 2^3 × 3^2 × 7, 
 * so rad(504) = 2 × 3 × 7 = 42.
 * 
 * We shall define the triplet of positive integers (a, b, c) to be an abc-hit if:
 * 
 * GCD(a, b) = GCD(a, c) = GCD(b, c) = 1
 * a < b
 * a + b = c
 * rad(abc) < c
 * For example, (5, 27, 32) is an abc-hit, because:
 * 
 * GCD(5, 27) = GCD(5, 32) = GCD(27, 32) = 1
 * 5 < 27
 * 5 + 27 = 32
 * rad(4320) = 30 < 32
 * It turns out that abc-hits are quite rare and there are only thirty-one abc-hits for c < 1000, with ∑c = 12523.
 *
 * Find ∑c for c < 120000.
 * 
 */
public class Problem127 {

	public static void main(String[] args) {
		long sum = 0;
		int count = 0;
		//int END = 1000;
		int END = 1200000;
		for ( int c = 1; c < END; c++ ) {
//			System.out.println("Processing " + c);

			for( int a = 1; a < c/2; a++ ) {
				List<Long> gcds = SievePrimeFactors.primeFactors(c);
				List<Long> gcdsA = SievePrimeFactors.primeFactors(a);
				if ( hasGcd(gcdsA, gcds) ) {
					continue;
				}
				int b = c - a;
				List<Long> gcdsB = SievePrimeFactors.primeFactors(b);
				if ( hasGcd(gcdsB, gcds) ) {
					continue;
				}
				if ( b == a ) { 
					throw new RuntimeException();
				}
				if ( isTriplet(a, gcdsA, b, gcdsB, c, gcds) ) {
					//System.out.println("..." + c + "(" + a + "," + b + ")");
					sum += c;
					count++;
				}
			}
		}
		System.out.println("Sum is " + sum);
		System.out.println("Count is " + count);
//		System.out.println("..." + isTriplet(5,27,32));
	}
	
	private static boolean hasGcd(List<Long> gcdsA, List<Long> gcds) {
		for (long gcd : gcds ) {
			if ( gcdsA.contains(gcd) ) { 
				return true;
			}
		}
		return false;
	}

	public static boolean isTriplet(long a, List<Long> gcdsA, long b, List<Long> gcdsB, long c, List<Long> gcdsC) {
//		long gcdAb = NumberUtil.gcd(a, b);
//		long gcdAc = NumberUtil.gcd(a, c);

		long gcdBc = NumberUtil.gcd(gcdsA, gcdsB);
		
		//System.out.println(a+"::"+b+"::"+c + "==>" + gcdAb + "," + gcdAc + "," + gcdBc);
		if ( gcdBc != 1 ) {
			return false;
		}
		//System.out.println("...passed");

		long rad = NumberUtil.multiply(gcdsA)*NumberUtil.multiply(gcdsB)*NumberUtil.multiply(gcdsC);
		//rad(a*b*c);
		if ( rad < c )  {
			//List<Long> gcdsMatch = SievePrimeFactors.primeFactors(a*b*c);
			System.out.println(a+"::"+b+"::"+c + "==>" + rad + "<" + c);// + "..." + Arrays.toString(gcds.toArray()));
		}
		return rad < c;
	}

	private static long rad(long i) {
		List<Long> gcds = SievePrimeFactors.primeFactors(i);
		long ret = 1;
		for (long val : gcds) { 
			ret *= val;
		}
		return ret;
	}

}
