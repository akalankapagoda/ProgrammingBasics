package com.dagger.programming.basics.model;

public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> left;

    private BinaryTreeNode<T> right;

    private T value;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value) {
        setLeft(left);
        setRight(right);
        setValue(value);
    }

    public BinaryTreeNode(T value) {
        setValue(value);
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;

        if (left != null ? !left.equals(that.left) : that.left != null) return false;
        if (right != null ? !right.equals(that.right) : that.right != null) return false;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + value.hashCode();
        return result;
    }
}
