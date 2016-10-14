package com.nthread.outthere.cracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SumList {

	public List<Integer> reverseSum(List<Integer> one, List<Integer> two) {
		List<Integer> returnList = new LinkedList<Integer>();
		int val = reverseSum(one, two, returnList);
		if ( val > 0 ) {
			returnList.add(0, val);
		}
		return returnList;
	}

	private int reverseSum(List<Integer> one, List<Integer> two, List<Integer> returnList) {
		if ( one.size() == 0 && two.size() == 0 ) { 
			return 0;
		}
		if ( one.size() > two.size() ) {
			return listAdd(returnList, one.get(0), 0, reverseSum(one.subList(1,  one.size()), two, returnList)); 
		}
		if ( one.size() < two.size() ) {
			return listAdd(returnList, two.get(0), 0, reverseSum(one, two.subList(1,  two.size()), returnList)); 
		}
		else {
			return listAdd(returnList, one.get(0), two.get(0), reverseSum(one.subList(1,  one.size()), two.subList(1,  two.size()), returnList)); 
		}
	}

	private int listAdd(List<Integer> returnList, int val1, int val2, int val3) {
		int sum = val1 + val2 + val3;
		returnList.add(0, sum % 10);
		return sum/10;

	}

}
