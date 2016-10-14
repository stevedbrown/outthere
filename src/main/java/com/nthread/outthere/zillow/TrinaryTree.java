package com.nthread.outthere.zillow;

import java.util.ArrayList;
import java.util.List;

public class TrinaryTree {
	
	TrinaryNode root = null;

	/**
	 * Inserts a list of values into the tree
	 */
	public void insert(int... vals) {
		if ( vals == null || vals.length == 0 ) {
			return;
		}
		for( int i : vals ) {
			insert(i);
		}
	}

	/**
	 * Inserts the given value into the tree, initializing the root node if necessary.
	 */
	public void insert(int i) {
		if ( root == null ) { 
			root = new TrinaryNode(i);
			return;
		}
		
		root = root.insert(i);
	}

	/**
	 * Returns the number of nodes in the tree
	 */
	public int size() {
		return root == null ? 0 : root.size();
	}

	/**
	 * Returns the depth of the tree
	 */
	public int depth() {
		return root == null ? 0 : root.depth();
	}

	/**
	 * Returns an array of Integers that result from an in order traversal of this tree
	 */
	public Integer[] inOrder() {
		if ( root == null )
			return new Integer[0];
		
		List<Integer> list = new ArrayList<Integer>();
		root.inOrder(list);
		return list.toArray(new Integer[0]);
			
	}

	/**
	 * Deletes a node from the tree with the given value
	 */
	public void delete(int i) {
		if ( root != null ) 
			root = root.delete(i);
	}
	
	/**
	 * Returns the root node of the three
	 */
	public TrinaryNode root() {
		return this.root;
	}

}
