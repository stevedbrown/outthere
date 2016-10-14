package com.nthread.outthere.zillow;

import java.util.List;

public class TrinaryNode {

	int val;
	
	TrinaryNode left = null;
	TrinaryNode center = null;
	TrinaryNode right = null;
	
	/** 
	 * Create a TrinaryNode
	 */
	public TrinaryNode(int i) {
		val = i;
	}

	/**
	 * Inserts the value into the children of this node
	 */
	public TrinaryNode insert(int i) {
		// Value is less, insert in left branch
		if ( i < val ) {
			if ( left == null )
				left = new TrinaryNode(i);
			else
				left.insert(i);
		}
		// Value is equal, insert in center branch
		else if ( i == val ) {
			if ( center == null ) 
				center = new TrinaryNode(i);
			else 
				center.insert(i);
		}
		// Value is greater, insert in right branch
		else { // i > val
			if ( right == null ) 
				right = new TrinaryNode(i);
			else 
				right.insert(i);
		}
		
		return this;
	}

	/**
	 * Returns the number of elements in this subtree
	 */
	public int size() {
		return 1 + 
				(left == null ? 0 : left.size()) + 
				(center == null ? 0 : center.size()) + 
				(right == null ? 0 : right.size());
				
	}

	/**
	 * Returns the depth of this node
	 */
	public int depth() {
		int leftDepth = left == null ? 0 : left.depth();
		int centerDepth = center == null ? 0 : center.depth();
		int rightDepth = right == null ? 0 : right.depth();
		
		return 1 + Math.max(Math.max(leftDepth, rightDepth), centerDepth);
	}

	/** 
	 * Performs an in order traversal of this node's children, adding them to the passed list
	 */
	public void inOrder(List<Integer> list) {
		if ( left != null )
			left.inOrder(list);
		if ( center != null )
			center.inOrder(list);
		list.add(this.val);
		if ( right != null )
			right.inOrder(list);
	}

	/**
	 * Deletes the specified value fro this node. If the value is equal to the current node,
	 * and the current node does not have any center (equal value) children, the min node from the right
	 * or max node from the left replaces this node (choosing the deeper of the two sides).
	 */
	public TrinaryNode delete(int i) {
		if ( ( i < val && left == null ) || ( i > val && right == null ) ) {
			return this;
		}
		
		// If the value is less than the current value, remove the value from the left branch
		if ( i < val ) {
			left = left.delete(i);
			return this;
		}
		
		if ( i > val ) {
			right = right.delete(i);
			return this;
		}
		
		// In the case that the center (equal value) branch has values, remove one
		if ( center != null ) {
			// If center.depth is 1, then the center node has no children, remove the reference
			if ( center.depth() == 1 ) {
				center = null;
			}
			else {
				center.delete(i);
			}
			return this;
		}

		// This is the case when the current node is being deleted
		// Find the depth of it's children
		int leftDepth = left != null ? left.depth() : 0;
		int rightDepth = right != null ? right.depth() : 0;
		
		// If this node has no children, then do nothing, just return null 
		if ( rightDepth == 0 && leftDepth == 0 ) {
			return null;
		}
		
		// If the right tree is deeper, use the max value from that branch
		if ( rightDepth > leftDepth ) {
			return shiftRight();
		}
		else {
			return shiftLeft();			
		}
	}

	/**
	 * In the case of a delete, this is used to return a pointer to a new root node, with the max value from
	 * the left tree
	 */
	private TrinaryNode shiftLeft() {
		int maxVal = left.getMaxChild();
		TrinaryNode root = new TrinaryNode(maxVal);
		root.left = left.delete(maxVal);
		root.right = right;
		return root;
	}
	/**
	 * In the case of a delete, this is used to return a pointer to a new root node, with the min value from
	 * the right tree
	 */
	private TrinaryNode shiftRight() {
		int minVal = right.getMinChild();
		TrinaryNode root = new TrinaryNode(minVal);
		root.left = left;
		root.right = right.delete(minVal);
		return root;
	}

	/**
	 * Returns the value of this node
	 */
	public int getVal() {
		return val;
	}
	
	/**
	 * Returns the minimum child value of this node, which will be from the left child if that
	 * exists or this node's value
	 */
	public int getMinChild() {
		return left != null ? left.getMinChild() : val;
	}

	/**
	 * Returns the maximum child value of this node, which will be from the right child if that
	 * exists or this node's value
	 */
	public int getMaxChild() {
		return right != null ? right.getMaxChild() : val;
	}

}
