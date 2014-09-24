package com.nthread.outthere.random;

public class PalindroneUtil {

	public static boolean isPalindrone(String candidate) {
		for (int i = 0; i < candidate.length()/2; i++ ) {
			if ( candidate.charAt(i) != candidate.charAt(candidate.length()-(1+i)) ) {
				return false;
			}
		}
		return true;
	}
}
