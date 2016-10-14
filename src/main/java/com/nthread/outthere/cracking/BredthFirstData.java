package com.nthread.outthere.cracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BredthFirstData {

	HashMap<String, SearchNodeData> visited = new HashMap<String, SearchNodeData>();
	Queue<SearchNodeData> toVisit = new LinkedList<SearchNodeData>();

	public BredthFirstData(String word) {
		SearchNodeData data = new SearchNodeData(word, null);
		toVisit.add(data);
		
	}
}
