package com.nthread.outthere.projecteuler;

import java.util.List;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each 
 * of the digits 0 to 9 in some order, but it also has a rather interesting sub-string 
 * divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * 
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem43 {

	public static void main(String[] args) {

		Tester<String> tester = new Tester<String>() {
			@Override
			public boolean test(String t) {
				return four3Divisible(t);
			}			
		};
		
		List<String> pans = PandigitalUtil.getPandigitals(tester);
		long sum = 0;
		for ( String val : pans ) { 
			sum += Long.parseLong(val);
		}
		System.out.println("sum is:" + sum);
	}

	public static boolean four3Divisible(String val) {
		return isDivisible(val.substring(1,4), 2) &&
				isDivisible(val.substring(2,5), 3) &&
				isDivisible(val.substring(3,6), 5) &&
				isDivisible(val.substring(4,7), 7) &&
				isDivisible(val.substring(5,8), 11) &&
				isDivisible(val.substring(6,9), 13) &&
				isDivisible(val.substring(7,10), 17);
	}

	private static boolean isDivisible(String substring, int i) {
		return Integer.parseInt(substring) % i == 0;
	}

}
