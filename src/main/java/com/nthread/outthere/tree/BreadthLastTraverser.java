package com.nthread.outthere.tree;

import java.util.*;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class BreadthLastTraverser implements Traverser {

    @Override
    public <E extends Comparable<E>> List<E> traverse(BinaryTreeNode<E> root) {
        List<E> vals = new ArrayList<E>();

        Stack<BinaryTreeNode<E>> stack = new Stack<BinaryTreeNode<E>>();
        Deque<BinaryTreeNode<E>> deck = new ArrayDeque<BinaryTreeNode<E>>();
        deck.push(root);
        while(!deck.isEmpty()) {
            BinaryTreeNode<E> e = deck.removeLast();
            stack.add(e);
            if(e.left != null )
                deck.push(e.left);
            if(e.right != null)
                deck.push(e.right);
        }
        while(!stack.isEmpty()) {
            vals.add(stack.pop().val);
        }
        return vals;
    }
}
