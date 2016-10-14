package com.nthread.outthere.tree;

import java.util.*;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class BreadthFirstTraverser implements Traverser {

    @Override
    public <E extends Comparable<E>> List<E> traverse(BinaryTreeNode<E> root) {
        List<E> vals = new ArrayList<E>();

        Queue<BinaryTreeNode<E>> deck = new ArrayDeque<>();
        deck.add(root);
        while(!deck.isEmpty()) {
            BinaryTreeNode<E> e = deck.remove();
            vals.add(e.val);
            if(e.left != null )
                deck.add(e.left);
            if(e.right != null)
                deck.add(e.right);
        }
        return vals;
    }
}
