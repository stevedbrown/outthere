package com.nthread.outthere.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class PandigitalUtil {
	
	public static List<Integer> NUMS = new ArrayList<Integer>();
	static {
		for ( int i = 0; i < 10; i++ ) {
			NUMS.add(i);
		}
	}

	public static List<String> getPandigitals(Tester<String> tester) {
		List<String> pans = new ArrayList<String>();
		
		addPandigitals(pans, "", NUMS, tester);
		
		return pans;
	}
	
	public static void addPandigitals(List<String> pans, String prefix, List<Integer> nums, 
			Tester<String> tester) {
		if ( nums.size() == 1 ) { 
			String val = prefix + nums.get(0);
			
			if ( tester.test(val)) {
				System.out.println("adding " + val);
				pans.add(prefix + nums.get(0));
			}
		}
		for ( int i = 0; i < nums.size(); i++ ) {
			int val = nums.remove(i);
			addPandigitals(pans, prefix + val, nums, tester);
			nums.add(i, val);
		}
	}
}
