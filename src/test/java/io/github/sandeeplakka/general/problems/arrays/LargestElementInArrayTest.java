package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestElementInArrayTest {

    private LargestElementInArray thisObj;

    @BeforeEach
    public void init() {
        thisObj = new LargestElementInArray();
    }

    @Test
    void test_largest() {
        assertEquals(90, thisObj.largest(new int[]{1, 8, 7, 56, 90}, 5));
        assertEquals(5, thisObj.largest(new int[]{1, 2, 0, 3, 2, 4, 5}, 7));
        assertEquals(-3, thisObj.largest(new int[]{-10, -7, -5, -3}, 4));
    }
}