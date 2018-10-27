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
        if (shouldGoLeft(number, parentNode)) {
            sendDeeper(number, parentNode, parentNode.leftChild);
        }
        sendDeeper(number, parentNode, parentNode.rightChild);
    }

    private void sendDeeper(Integer number, Node parentNode, Node childNode) {
        if (parentHasChild(childNode)) {
            manageNewNumber(number, childNode);
        }
        createNewNode(number, parentNode);
    }

    private boolean shouldGoLeft(Integer number, Node node) {
        return number <= node.value;
    }

    private boolean isNotRootIndex(int index, Integer[] array) {
        return index == getMiddleIndex(array);
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
        return array.length / 2;
    }

    public int getRoot() {
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
        }
    }
}
