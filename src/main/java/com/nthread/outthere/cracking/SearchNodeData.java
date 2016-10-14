package com.nthread.outthere.cracking;

public class SearchNodeData {

	String word;
	SearchNodeData previous;

	public SearchNodeData(String word, SearchNodeData previous) {
		this.word = word;
		this.previous = previous;
	}

}
