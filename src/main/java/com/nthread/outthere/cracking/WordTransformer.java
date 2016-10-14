package com.nthread.outthere.cracking;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordTransformer {

	HashMap<String, List<String>> dict = new HashMap<String, List<String>>();
	private List<String> EMPTY_LIST = new ArrayList<String>();
	
	/** 
	 * Constructor sets data up
	 */
	public WordTransformer()  {
		try {
			String contents = "";
			List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("/Users/stephenbrown/code/outthere/src/main/java/com/nthread/outthere/cracking/words.json"));
			for (String line : lines) { 
				contents += line;
			}
			while (contents.contains("\"word\":")) {
				contents = contents.substring(contents.indexOf("\"word\":\"") + 8);
				String word = contents.substring(0, contents.indexOf("\""));
				List<String> wildcards = getWildcards(word);
				for ( String wc : wildcards ) { 
					if (!dict.containsKey(wc) ) { 
						dict.put(wc, new ArrayList<String>());
					}
					//System.out.printf("...mapping %s ==> %s\n", wc, word);
					dict.get(wc).add(word);
					//System.out.printf("...mapping %s ==> %s [%s]\n", wc, word, Arrays.toString(dict.get(wc).toArray()));
				}
			}
		} catch (IOException ioe) { 
			ioe.printStackTrace();
		}
	}
	
	private List<String> getWildcards(String word) {
		List<String> val = new ArrayList<String>();		
		for ( int i = 0; i < word.length(); i++ ) { 
			val.add(word.substring(0, i) + "_" + (word.length() > i ? word.substring(i+1, word.length()) : ""));
		}
		return val;
	}
	
	public List<String> path(String from, String to) {
		BredthFirstData start = new BredthFirstData(from);
		BredthFirstData end = new BredthFirstData(to);
		System.out.printf("...%d:::%d\n", start.toVisit.size(), end.toVisit.size());
		while (!start.toVisit.isEmpty() && ! end.toVisit.isEmpty() ) {
			String collision = searchLevel(start, end);
			if ( collision != null ) { 
				return mergedResults(collision, start, end);
			}
			collision = searchLevel(end, start);
			if ( collision != null ) { 
				return mergedResults(collision, start, end);
			}
		}
		return null;
	}

	private List<String> mergedResults(String collision, BredthFirstData start, BredthFirstData end) {
		List<String> list = new ArrayList<String>();
		SearchNodeData node = start.visited.get(collision);
		while(node != null) {
			list.add(0, node.word);
			node = node.previous;
		}
		node = end.visited.get(collision).previous;
		while(node != null) {
			list.add(node.word);
			node = node.previous;
		}
		return list;
	}

	private String searchLevel(BredthFirstData data, BredthFirstData other) {
		System.out.printf("...searchLevel %d\n", data.toVisit.size());
		int count = data.toVisit.size();
		for (int i = 0; i < count; i++) {
			SearchNodeData node = data.toVisit.poll();
			if ( data.visited.containsKey(node.word)) {
				continue;
			}
			data.visited.put(node.word, node);
			if ( other.visited.containsKey(node.word) ) {
				return node.word;
			}
			
			List<String> wildcards = getWildcards(node.word);
			for ( String wildcard : wildcards ) { 
				List<String> words = dict.containsKey(wildcard) ? dict.get(wildcard) : EMPTY_LIST;
				for (String word : words ) { 
					data.toVisit.add(new SearchNodeData(word, node));
				}
			}
			
		}
		
		return null;
	}
}
