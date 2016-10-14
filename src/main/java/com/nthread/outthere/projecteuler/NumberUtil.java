package com.nthread.outthere.projecteuler;

import java.util.Arrays;
import java.util.List;

public class NumberUtil {

	public static boolean isPermutation(long... numbers) {
		String digits = sortString(Long.toString(numbers[0]));
		for ( int i = 1; i < numbers.length; i++ ) {
			if ( ! digits.equals(sortString(Long.toString(numbers[i])))) {
				return false;
			}
		}
		return true;
	}
	
	public static String sortString(String original) {
		char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
	}

	public static long gcd(long i, long j) {
		List<Long> iFactors = SievePrimeFactors.primeFactors(i);
		List<Long> jFactors = SievePrimeFactors.primeFactors(j);
		return gcd(iFactors, jFactors);
	}

	public static long gcd(List<Long> iFactors, List<Long> jFactors) {
		Long gcd = 1l;
		int iPos = 0, jPos = 0;
		while( iPos < iFactors.size() && jPos < jFactors.size() ) {
			int comp = iFactors.get(iPos).compareTo(jFactors.get(jPos));
			if ( comp == 0 ) { 
				gcd = iFactors.get(iPos++);
				jPos++;
			}
			else if ( comp < 1 ) {
				iPos++;
			}
			else {
				jPos++;
			}
		}
		return gcd;
	}

	public static long multiply(List<Long> gcds) {
		long product = 1;
		
		for ( long val : gcds)
			product*= val;
		
		return product;
	}
	
	

}
