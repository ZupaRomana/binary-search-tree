package com.codecool;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void initialize(Integer[] array) {
        initializeRoot(array);
    }

    private void initializeRoot(Integer[] array) {
        int rootValue = getMiddleValue(array);
        root = createNewNode(rootValue);
    }

    private Node createNewNode(int rootValue) {
        return new Node(rootValue);
    }

    private int getMiddleValue(Integer[] array) {
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

        Node(int value) {
            this.value = value;
        }
    }
}
