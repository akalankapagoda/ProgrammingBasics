package com.dagger.programming.basics.traversal;

import com.dagger.programming.basics.model.BinaryTreeNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class BinaryTreeTraversalTest {

    private static BinaryTreeNode<Integer> root;
    private static BinaryTreeTraversal binaryTreeTraversal;

    @BeforeClass
    public static void setUp() {

        binaryTreeTraversal = new BinaryTreeTraversal();

        /*
            The tree would be like below.
                          4
                       /     \
                     1         3
                  /    \     /   \
                 5      2   0     1
                /                  \
               9                    23

         */

        BinaryTreeNode<Integer> four = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> one = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> five = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> nine = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> two = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> three = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> zero = new BinaryTreeNode<>(0);
        BinaryTreeNode<Integer> secondOne = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> twentyThree = new BinaryTreeNode<>(23);

        four.setLeft(one);
        four.setRight(three);

        one.setLeft(five);
        one.setRight(two);

        five.setLeft(nine);

        three.setLeft(zero);
        three.setRight(secondOne);

        secondOne.setRight(twentyThree);

        root = four;

    }

    @Test
    public void testDepthFirstInOrderTraversal() {

        Integer[] expected = {9, 5, 1, 2, 4, 0, 3, 1, 23};

        List<Object> results = binaryTreeTraversal.depthFirstInOrderTraversal(root);

        Assert.assertEquals("Result size is incorrect", expected.length, results.size());

        Assert.assertArrayEquals("Order mismatch", expected, results.toArray());
    }

    @Test
    public void testDepthFirstPreOrderTraversal() {

        Integer[] expected = {4, 1, 5, 9, 2, 3, 0, 1, 23};

        List<Object> results = binaryTreeTraversal.depthFirstPreOrderTraversal(root);

        Assert.assertEquals("Result size is incorrect", expected.length, results.size());

        Assert.assertArrayEquals("Order mismatch", expected, results.toArray());
    }

    @Test
    public void testDepthFirstPostOrderTraversal() {

        Integer[] expected = {9, 5, 2, 1, 0, 23, 1, 3, 4};

        List<Object> results = binaryTreeTraversal.depthFirstPostOrderTraversal(root);

        Assert.assertEquals("Result size is incorrect", expected.length, results.size());

        Assert.assertArrayEquals("Order mismatch", expected, results.toArray());
    }
}
