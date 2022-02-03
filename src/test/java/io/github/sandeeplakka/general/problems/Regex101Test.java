package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Regex101Test {

    private Regex101 thisObj;

    @BeforeEach
    public void init() {
        thisObj = new Regex101();
    }

    @Test
    public void testRegex() {
        assertEquals("assertArrayEquals(new int[]{1, 2, 3}, halfIt(new int[]{2, 4, 6}), \"Failed for test case [2, 4, 6]\");",
                thisObj.regex("assertArrayEquals(\"Failed for test case [2, 4, 6]\", new int[]{1, 2, 3}, halfIt(new int[]{2, 4, 6}));"));
        assertEquals("assertArrayEquals(new int[]{2, 4, 6}, doubleIt(new int[]{1, 2, 3}), \"Failed for test case [1, 2, 3]\");",
                thisObj.regex("assertArrayEquals(\"Failed for test case [1, 2, 3]\", new int[]{2, 4, 6}, doubleIt(new int[]{1, 2, 3}));"));
        assertThrows(IllegalArgumentException.class, () -> thisObj.regex(null));
    }
}