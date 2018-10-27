package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    void returnsValidRoot() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.initialize(array);

        int expected = 5;
        int actual = tree.getRoot();

        assertEquals(expected, actual);
    }

    @Test
    void throwsException_when_emptyArrayPassed() {
        final BinarySearchTree tree = new BinarySearchTree();

        assertThrows(IllegalArgumentException.class, () -> {
            tree.initialize(new Integer[]{});
        });
    }
}