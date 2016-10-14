package com.nthread.outthere.tree;

import java.util.Comparator;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {

    BinaryTreeNode left = null;
    BinaryTreeNode right = null;

    T val;

    BinaryTreeNodeOperator operator;

    BinaryTreeNode(T val) {
        this.val = val;
        this.operator = new BinaryTreeNodeOperator();
    }

    BinaryTreeNode(T val, BinaryTreeNodeOperator operator) {
        this.val = val;
        this.operator = operator;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void addNode(BinaryTreeNode node) {
        operator.addNode(this, node);
    }

    public void addNode(T val) {
        operator.addNode(this, new BinaryTreeNode(val, this.operator));
    }

    public void addNodes(T... vals) {
        for (T val : vals) {
            addNode(val);
        }
    }

    public int compareTo(BinaryTreeNode<T> other) {
        return this.val.compareTo(other.val);
    }
}
