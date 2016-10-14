package com.nthread.outthere.zillow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;

public class TrinaryTreeTest {

	@Test
	public void testInsert() {
		TrinaryTree tree = new TrinaryTree();
		// Test that insert does not respond poorly to null input
		tree.insert();
		
		tree.insert(5);
		// Expecting
		//		5
		assertEquals(1, tree.size());
		assertEquals(1, tree.depth());
		
		tree.insert(4);
		// Expecting
		//		5
		//	  /
		//	  4
		assertEquals(2, tree.size());
		assertEquals(2, tree.depth());
		
		tree.insert(9, 5, 7, 2, 2);
		// Expecting
		//		5
		//	  / | \
		//	  4 5 9
		//	 /   /
		//	2   7
		//	|
		//	2
		assertEquals(7, tree.size());
		assertEquals(4, tree.depth());
		
		assertArrayEquals(new Integer[]{2, 2, 4, 5, 5, 7, 9}, tree.inOrder());
	}

	@Test
	public void testMaxChild() {
		TrinaryTree tree = new TrinaryTree();
		tree.insert(5, 4, 9, 5, 7, 2, 2);
		assertEquals(9, tree.root.getMaxChild());
	}

	@Test
	public void testMinChild() {
		TrinaryTree tree = new TrinaryTree();
		tree.insert(5, 4, 9, 5, 7, 2, 2);
		assertEquals(2, tree.root.getMinChild());
	}
	
	@Test
	public void testDelete() {
		TrinaryTree tree = new TrinaryTree();
		
		tree.insert(5, 4, 9, 5, 7, 2, 2);
		assertEquals(7, tree.size());
		assertEquals(4, tree.depth());
		
		// Same case as above
		assertArrayEquals(new Integer[]{2, 2, 4, 5, 5, 7, 9}, tree.inOrder());		

		// This should have no impact as the value is not present
		tree.delete(99);
		assertEquals(7, tree.size());
		assertEquals(4, tree.depth());
		assertArrayEquals(new Integer[]{2, 2, 4, 5, 5, 7, 9}, tree.inOrder());	
		
		tree.delete(5);
		// Expecting
		//		5
		//	  /   \
		//	  4   9
		//	 /   /
		//	2   7
		//	|
		//	2
		assertEquals(6, tree.size());
		assertEquals(4, tree.depth());
		assertArrayEquals(new Integer[]{2, 2, 4, 5, 7, 9}, tree.inOrder());

		tree.delete(5);
		// Expecting
		//		4
		//	  /   \
		//	  2   9
		//	 /   /
		//	2   7
		assertEquals(4, tree.root().getVal());
		assertEquals(5, tree.size());
		assertEquals(3, tree.depth());
		assertArrayEquals(new Integer[]{2, 2, 4, 7, 9}, tree.inOrder());

		tree.delete(9);
		// Expecting
		//		4
		//	  /   \
		//	  2   7
		//	 /
		//	2
		assertEquals(4, tree.root().getVal());
		assertEquals(4, tree.size());
		assertEquals(3, tree.depth());
		assertArrayEquals(new Integer[]{2, 2, 4, 7}, tree.inOrder());
		
		tree.delete(2);
		// Expecting
		//		4
		//	  /   \ 
		//	  2   7 
		assertEquals(4, tree.root().getVal());
		assertEquals(3, tree.size());
		assertEquals(2, tree.depth());
		assertArrayEquals(new Integer[]{2, 4, 7}, tree.inOrder());

		tree.delete(2);
		// Expecting
		//		4
		//	     \
		//	     7
		assertEquals(4, tree.root().getVal());
		assertEquals(2, tree.size());
		assertEquals(2, tree.depth());
		assertArrayEquals(new Integer[]{4, 7}, tree.inOrder());

		tree.delete(4);
		// Expecting
		//		7
		assertEquals(7, tree.root().getVal());
		assertEquals(1, tree.size());
		assertEquals(1, tree.depth());
		assertArrayEquals(new Integer[]{7}, tree.inOrder());

		tree.delete(7);
		// Expecting
		//		<null>
		assertNull(tree.root());
		assertArrayEquals(new Integer[]{}, tree.inOrder());
	}
}
