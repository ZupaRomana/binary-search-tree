package com.codecool;

public class BinarySearchTree {
    Node root;

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
        if (isEqual(number, root)) {
            changeLeftChild(number, root);
        }
    }

    private void changeLeftChild(int number, Node parent) {
        Node child = createNewNode(number, parent);
        swapRelationships(parent, child);
        parent.leftChild = child;
    }

    private void changeRightChild(int number, Node parent) {
        Node child = createNewNode(number, parent);
        swapRelationships(parent, child);
        parent.rightChild = child;
    }

    private void swapRelationships(Node parent, Node child) {
        child.leftChild = parent.leftChild;
        child.rightChild = parent.rightChild;
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

    private void manageNewNumber(Integer number, Node parentNode) {
        if (isValueLessOrEqual(number, parentNode)) {
            setAsLeftChild(number, parentNode);
        }
        setAsRightChild(number, parentNode);
    }

    private void setAsLeftChild(Integer number, Node parentNode) {
        if (isChild(parentNode.leftChild)) {
            manageNewNumber(number, parentNode.leftChild);
        }
        parentNode.leftChild = createNewNode(number, parentNode);
    }

    private void setAsRightChild(Integer number, Node parentNode) {
        if (isChild(parentNode.rightChild)) {
            manageNewNumber(number, parentNode.rightChild);
        }
        parentNode.rightChild = createNewNode(number, parentNode);
    }

    private boolean isChild(Node childNode) {
        return childNode != null;
    }

    private boolean isValueLessOrEqual(Integer number, Node node) {
        return number <= node.value;
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
