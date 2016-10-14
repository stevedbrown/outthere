package com.nthread.outthere.cracking;

import java.util.List;
import java.util.Stack;

public class ListPalindrome {

	public boolean isPalindrome(List<Integer> list) {
		Stack<Integer> firstHalf = new Stack<Integer>();
		for (int i = 0; i < list.size(); i++ ) {
			// Midpoint
			if (list.size() % 2 == 1 && i == list.size()/2 ) {
				
			}
			// Before half
			else if (i < (list.size()/2) ) {
				System.out.printf("adding %d\n", list.get(i));
				firstHalf.add(list.get(i));
			}
			// After half, checking values
			else {
				int val = firstHalf.pop();
				System.out.printf("checking [%d] %d != %d\n", i, val, list.get(i));
				if (val != list.get(i) ) {
					System.out.println("===>false");
					return false;
				}
			}
		}
		
		return true;
	}

}
