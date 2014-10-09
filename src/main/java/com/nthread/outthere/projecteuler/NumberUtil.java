package com.nthread.outthere.projecteuler;

import java.util.Arrays;

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

}
