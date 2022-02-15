package io.github.sandeeplakka.general.problems.bits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetBitsFinderTest {

    private SetBitsFinder testObj;

    @BeforeEach
    public void init() {
        testObj = new SetBitsFinder();
    }

    @Test
    void test_findSetBits() {
        assertEquals(2, testObj.findSetBits(3));
        assertEquals(1, testObj.findSetBits(16));
        assertEquals(4, testObj.findSetBits(15));
        assertEquals(0, testObj.findSetBits(0));
    }
}