package com.nthread.outthere.tree;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class BreadthFirstTest {

    @Test
    public void testPreorderOne() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(25);
        root.addNodes(6, 10, 23, 99, 75, 102, 3, 13, 216, 156, 7, 18, 217);
        BinaryTreePrinter.printNode(root);

        List<Integer> preorderList = (new BreadthFirstTraverser()).traverse(root);
        assertNotNull(preorderList);

        List<Integer> expected = Lists.newArrayList(25, 6, 99, 3, 10, 75, 102, 7, 23, 216, 13, 156, 217, 18);
        assertEquals(expected, preorderList);

    }
}
