package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    void returnsValidRoot_when_evenElements() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.initialize(array);

        int expected = 6;
        int actual = tree.getRootValue();

        assertEquals(expected, actual);
    }

    @Test
    void returnsValidRoot_when_oddElements() {
        BinarySearchTree tree = new BinarySearchTree();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        tree.initialize(arr);

        int expected = 5;
        int actual = tree.getRootValue();

        assertEquals(expected, actual);
    }

    @Test
    void throwsException_when_emptyArrayPassed() {
        BinarySearchTree tree = new BinarySearchTree();

        assertThrows(IllegalArgumentException.class, () -> {
            tree.initialize(new Integer[]{});
        });
    }

    @Test
    void returnsTrue_when_lookingForValidElem() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.initialize(array);

        assertTrue(tree.contains(10));
    }

    @Test
    void returnsTrue_when_newElementPassedContainsInvoked() {
        BinarySearchTree tree = new BinarySearchTree();
        Integer[] arr = new Integer[]{1, 2, 3, 5, 7};
        tree.initialize(arr);
        tree.add(4);

        assertTrue(tree.contains(4));
    }
}