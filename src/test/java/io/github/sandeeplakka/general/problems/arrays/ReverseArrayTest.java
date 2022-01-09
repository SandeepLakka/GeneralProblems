package io.github.sandeeplakka.general.problems.arrays;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseArrayTest {

    private ReverseArray reverseArray;

    @BeforeEach
    public void init() {
        reverseArray = new ReverseArray();
    }

    @Test
    void reverseArray() {
        assertArrayEquals(new int[]{1, 2, 3}, reverseArray.reverseArray(new int[]{3, 2, 1}));
        assertArrayEquals(new int[]{1, 1}, reverseArray.reverseArray(new int[]{1, 1}));
        assertArrayEquals(new int[]{0}, reverseArray.reverseArray(new int[]{0}));
        assertArrayEquals(new int[]{}, reverseArray.reverseArray(new int[]{}));
        assertThrows(IllegalArgumentException.class, () -> reverseArray.reverseArray(null));
    }
}