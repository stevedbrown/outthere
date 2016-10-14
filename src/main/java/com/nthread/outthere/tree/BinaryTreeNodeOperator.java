package com.nthread.outthere.tree;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class BinaryTreeNodeOperator {

    public void addNode(BinaryTreeNode node, BinaryTreeNode addedNode) {
        if (node.val.equals(addedNode.val)) {
            return; // don't add
        }

        if (addedNode.compareTo(node) < 0) {
            if (node.left == null) {
                node.left = addedNode;
            }
            else {
                addNode(node.left, addedNode);
            }
        }
        else {
            if (node.right == null) {
                node.right = addedNode;
            }
            else {
                addNode(node.right, addedNode);
            }

        }
    }

}
