package com.dagger.programming.basics.traversal;

import com.dagger.programming.basics.model.BinaryTreeNode;

import java.util.*;

public class BinaryTreeTraversal {

    /**
     *  (Left, Root, Right)
     * @param root
     */
    public List<Object> depthFirstInOrderTraversal(BinaryTreeNode root) {

        List<Object> traversedOrder = new LinkedList<>();

        Stack<BinaryTreeNode> stack = new Stack();

        stack.push(root);

        Set<BinaryTreeNode> traversed = new HashSet<>();

        while (!stack.empty()) {

            BinaryTreeNode currentNode = stack.pop();

            while (currentNode.getLeft() != null) {

                if (traversed.contains(currentNode.getLeft())) {
                    break;
                }

                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            traversedOrder.add(currentNode.getValue());
            System.out.println(currentNode.getValue());

            traversed.add(currentNode);

            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }

        }

        return traversedOrder;
    }

    /**
     *  (Root, Left, Right)
     * @param root
     */
    public List<Object> depthFirstPreOrderTraversal(BinaryTreeNode root) {

        List<Object> traversedOrder = new LinkedList<>();

        Stack<BinaryTreeNode> stack = new Stack();

        stack.push(root);

        Set<BinaryTreeNode> traversed = new HashSet<>();

        while (!stack.empty()) {

            BinaryTreeNode currentNode = stack.pop();

            if(traversed.contains(currentNode) && currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
                break;
            }

            traversedOrder.add(currentNode.getValue());
            System.out.println(currentNode.getValue());

            traversed.add(currentNode);

            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }

            BinaryTreeNode<Integer> nextLeftNode = currentNode.getLeft();
            while (nextLeftNode != null) {

                Object nextLeftNodeValue = nextLeftNode.getValue();
                traversedOrder.add(nextLeftNodeValue);
                System.out.println(nextLeftNodeValue);

                traversed.add(nextLeftNode);

                BinaryTreeNode<Integer> nextRightNode = nextLeftNode.getRight();

                if (nextRightNode != null) {
                    stack.push(nextRightNode);
                }

                nextLeftNode = nextLeftNode.getLeft();

            }

        }

        return traversedOrder;
    }

    /**
     *  (Left, Right, Root)
     * @param root
     */
    public List<Object> depthFirstPostOrderTraversal(BinaryTreeNode root) {

        List<Object> traversedOrder = new LinkedList<>();

        Stack<BinaryTreeNode> stack = new Stack();

        stack.push(root);

        Set<BinaryTreeNode> traversed = new HashSet<>();

        while (!stack.empty()) {

            BinaryTreeNode currentNode = stack.peek();

            BinaryTreeNode left = currentNode.getLeft();
            BinaryTreeNode right = currentNode.getRight();

            if (left != null && !traversed.contains(left)) {

                while (left != null) {
                    stack.add(left);
                    left = left.getLeft();
                }
            } else if (right != null && !traversed.contains(right)) {
                stack.add(right);
            } else {
                traversedOrder.add(currentNode.getValue());
                System.out.println(currentNode.getValue());
                traversed.add(currentNode);
                stack.pop();
            }


        }

        return traversedOrder;
    }
}
