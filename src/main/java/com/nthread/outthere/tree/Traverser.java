package com.nthread.outthere.tree;

import java.util.List;

/**
 * Created by stephenbrown on 8/23/15.
 */
public interface Traverser {
    public <E extends Comparable<E>> List<E> traverse(BinaryTreeNode<E> root);
}
