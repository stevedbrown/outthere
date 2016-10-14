package com.nthread.outthere.cracking;

import java.util.ArrayList;
import java.util.List;

public class ListReverser {

	public List<Integer> reverse(List<Integer> list) {
		List<Integer> reversed = new ArrayList<Integer>();
		reverse(list, reversed);
		return reversed;
	}

	private void reverse(List<Integer> list, List<Integer> reversed) {
		if(list.size()>1) {
			reverse(list.subList(1, list.size()), reversed);
		}

		reversed.add(list.get(0));
	}

}
