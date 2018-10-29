package com.codecool;

import java.util.NoSuchElementException;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void initialize(Integer[] array) throws IllegalArgumentException {
        if (isArrayEmpty(array)) {
            throw new IllegalArgumentException();
        } else {
            initializeRoot(array);
            buildTree(array);
        }
    }

    public boolean contains(int number) {
        return equalsNodeValue(number, root);
    }

    public void add(int number) {
        manageNewNumber(number, root);
    }

    public void remove(int number) throws NoSuchElementException {
        if (!contains(number)) {
            throw new NoSuchElementException();
        } else {
            Node nodeToRemove = find(number, root);
            Node nodeToReplace = getLastLeftChildFromRightChild();
            swapNodes(nodeToRemove);
        }
    }

    private void changeReferences(int number, Node nodeToRemove) {
        if (isEqual(number, nodeToRemove)) {

        }
    }

    private boolean equalsRoot(Node nodeToRemove) {
        return nodeToRemove == root;
    }

    private Node find(int number, Node node) {
        if (isEqual(number, node)) {
            return node;
        } else if (isLess(number, node)) {
            return find(number, node.leftChild);
        } else {
            return find(number, node.rightChild);
        }
    }

    private void changeLeftChild(int number, Node parent) {
        Node child = createNewNode(number, parent);
        swapRelationships(parent, child);
        parent.leftChild = child;
    }

    private void swapRelationships(Node newParent, Node newChild) {
        newChild.leftChild = newParent.leftChild;
        newChild.rightChild = newParent.rightChild;
    }

    private boolean equalsNodeValue(int number, Node node) {
        if (isEqual(number, node)) {
            return true;
        } else if (isLess(number, node)) {
            return node.leftChild == null ? false : equalsNodeValue(number, node.leftChild);
        } else {
            return node.rightChild == null ? false : equalsNodeValue(number, node.rightChild);
        }
    }

    private boolean isLess(int number, Node node) {
        return number < node.value;
    }

    private boolean isEqual(int number, Node node) {
        return number == node.value;
    }

    private boolean isArrayEmpty(Integer[] array) {
        return array.length == 0;
    }

    private void buildTree(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (isNotRootIndex(i, array)) {
                manageNewNumber(array[i], root);
            }
        }
    }

    private void manageNewNumber(Integer number, Node node) {
        if (isEqual(number, node)) {
            changeLeftChild(number, node);
        } else if (isLess(number, node)) {
            setAsLeftChild(number, node);
        } else {
            setAsRightChild(number, node);
        }
    }

    private void setAsLeftChild(Integer number, Node parentNode) {
        if (isChild(parentNode.leftChild)) {
            manageNewNumber(number, parentNode.leftChild);
        } else {
            parentNode.leftChild = createNewNode(number, parentNode);
        }
    }

    private void setAsRightChild(Integer number, Node parentNode) {
        if (isChild(parentNode.rightChild)) {
            manageNewNumber(number, parentNode.rightChild);
        } else {
            parentNode.rightChild = createNewNode(number, parentNode);
        }
    }

    private boolean isChild(Node childNode) {
        return childNode != null;
    }

    private boolean isNotRootIndex(int index, Integer[] array) {
        return index != getMiddleIndex(array);
    }

    private void initializeRoot(Integer[] array) {
        int rootValue = getMiddleValue(array);
        root = createNewNode(rootValue, null);
    }

    private int getMiddleValue(Integer[] array) {
        return array[getMiddleIndex(array)];
    }

    private Node createNewNode(int value, Node parentNode) {
        return new Node(value, parentNode);
    }

    private int getMiddleIndex(Integer[] array) {
        return Math.round(array.length / 2);
    }

    public int getRootValue() {
        return getNodeValue(root);
    }

    private int getNodeValue(Node node) {
        return node.value;
    }

    private class Node {
        private int value;
        private Node parentNode;
        private Node leftChild;
        private Node rightChild;

        Node(int value, Node parentNode) {
            this.value = value;
            this.parentNode = parentNode;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
