package com.nthread.outthere.tree;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by stephenbrown on 8/23/15.
 */
public class IterativeInorderTest {

    @Test
    public void testPreorderOne() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(25);
        root.addNodes(6, 10, 23, 99, 75, 102, 3, 13, 216, 156, 7, 18, 217);
        BinaryTreePrinter.printNode(root);

        List<Integer> preorderList = (new IterativeInorderTraverser()).traverse(root);
        assertNotNull(preorderList);

        List<Integer> expected = Lists.newArrayList(3, 6, 7, 10, 13, 18, 23, 25, 75, 99, 102, 156, 216, 217);
        assertEquals(expected, preorderList);
    }
}
