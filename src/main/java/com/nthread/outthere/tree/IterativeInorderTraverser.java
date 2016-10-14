package com.nthread.outthere.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class IterativeInorderTraverser implements Traverser {

    @Override
    public <E extends Comparable<E>> List<E> traverse(BinaryTreeNode<E> node) {
        List<E> vals = new ArrayList<E>();
        Stack<BinaryTreeNode<E>> stack = new Stack<BinaryTreeNode<E>>();

        while(!stack.isEmpty() || node != null ) {
            if (node != null) { // node is null, pop, process, if right, add right
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                vals.add(node.val);
                node = node.right;

            }
        }
        return vals;
    }
}
