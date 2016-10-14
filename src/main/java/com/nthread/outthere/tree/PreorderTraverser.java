package com.nthread.outthere.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class PreorderTraverser {

    public <E extends Comparable<E>> List<E> traverse(BinaryTreeNode<E> node) {
        return traverse(node, new ArrayList<E>());
    }

    public <E extends Comparable<E>> List<E> traverse(BinaryTreeNode<E> node, ArrayList<E> list) {
        list.add(node.val);
        if ( node.left != null ) {
            this.traverse(node.left, list);
        }
        if ( node.right != null ) {
            this.traverse(node.right, list);
        }
        return list;
    }
}
