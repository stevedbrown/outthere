package com.nthread.outthere.samples;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an individual node in a pattern b-tree. The children are stored in a Map, keyed off the pattern 
 * element they represent. For example, a,b,c,d would have 4 pattern elements, d would be a child of c which would be a 
 * child of b, which in turn would be a child of a.
 * 
 * If you additionally added a,b,d,c and a,b,*,c to the same root node, the structure would be:
 * a
 *  \
 *   b
 *  /|\
 * d * c
 * | |  \
 * c c   d
 * @author stephenbrown
 *
 */
public class PatternNode {
	private static final String WILDCARD = "*";

	/**
	 * This children of this node will be keyed off of the single level of the patterns they represent. If
	 * the path was a,b,c and this was the 'a' level, they key for the child would be 'b'.
	 */
	public Map<String, PatternNode> children = new HashMap<String, PatternNode>(); 
	
	/**
	 * Indicates whether this node represents the end of a path. For example, in the a,b,c case, the node represented
	 * by c would have terminal true.
	 */
	boolean terminal = false;
	
	/**
	 * No constructor behavior required.
	 */
	public PatternNode() {
	}

	/**
	 * This method takes a pattern sting with the elements separated by commas. It splits the pattern and passes it to
	 * the addPattern helper method that takes an array of Strings
	 */
	public void addPattern(String pattern) {
		String[] elements = pattern.split(",");
		addPattern(elements, 0);
	}

	/**
	 * Responsible for creating child PatternNodes as required to complete the whole path, setting the end
	 * child to terminal = true;
	 */
	private void addPattern(String[] elements, int position) {
		// Checks if elements are null of you're past the last element in the chain
		if ( elements == null || elements.length == position ) {
			return;
		}
		
		// Gets the node for the current match rule
		PatternNode node = children.get(elements[position]);
		
		// If the node is null, create it and add it to the children Map
		if ( node == null ) { 
			node = new PatternNode();
			children.put(elements[position], node);
		}
		// Terminal could be set by a different pass of path creation, leave that value in place.
		// If elements.length == start+1, this is the last element in the pattern.
		node.terminal = node.terminal || elements.length == position+1;
		
		//calls add pattern on the newly created child, one level deeper.
		node.addPattern(elements, position+1);
	}

	/**
	 * This method takes a path seperated by slashes "/", parses them into an array, and calls the findPath
	 * helper method.
	 */
	public String findPath(String path) {
		if ( path == null ) {
			return null;
		}
		
		// Need to remove leading slashes from the path
		String[] elements = path.replaceAll("^/", "").split("/");
		return findPath(elements, 0);
	}

	/**
	 * Looks for matching paths in this node, checking both wildcard paths and key match paths.
	 */
	private String findPath(String[] elements, int start) {
		if ( elements == null || elements.length == start ) {
			return terminal ? "" : null;
		}

		// The children of this node are searched for the current element as well as for a wildcard node
		PatternNode keyNode = children.get(elements[start]);
		PatternNode wildcardNode = children.get(WILDCARD);

		// the nodes are searched for matches
		String keyResult = keyNode == null ? null : keyNode.findPath(elements, start+1);
		String wildcardResult = wildcardNode == null ? null : wildcardNode.findPath(elements, start+1);
		
		String key = null;
		String result = null;
		
		// If there is only a wildcard match, return it.
		if (keyResult != null && wildcardResult == null ) { 
			key = elements[start];
			result = keyResult;
		}
		// If there is only a key result, return it.
		else if (keyResult == null && wildcardResult != null ) { 
			key = WILDCARD;
			result = wildcardResult;
		}
		// If there are both key and wildcard result, return the one with the least wildcards, tie
		// going to the least recent wildcard node
		else if (keyResult != null && wildcardResult != null ) { 
			// Find the count by removing the non-wildcard characters and checking the length
			int keyCount = keyResult.replaceAll("[a-zA-Z,]", "").length();
			int wildcardCount = wildcardResult.replaceAll("[a-zA-Z,]", "").length()+1;
			
			// If the key node result has more wildcards, return it.
			if ( keyCount > wildcardCount ) { 
				key = WILDCARD;
				result = wildcardResult;
			}
			else {
				key = elements[start];
				result = keyResult;
			}
		}
		else {
			return null;
		}
		
		// The return will pre-pend the node key with a comma unless it is the first result.
		return String.format("%s%s%s", start != 0 ? "," : "", key, result);
	}
}
