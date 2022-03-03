package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateNumberTest {

    private FindDuplicateNumber underTest;

    @BeforeEach
    public void init() {
        underTest = new FindDuplicateNumber();
    }

    @Test
    void test_getDuplicate() {
        assertEquals(2, underTest.getDuplicate(new int[]{1, 3, 4, 2, 2}));
        assertEquals(3, underTest.getDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    void test_getDuplicateWithSet() {
        assertEquals(2, underTest.getDuplicateWithSet(new int[]{1, 3, 4, 2, 2}));
        assertEquals(3, underTest.getDuplicateWithSet(new int[]{3, 1, 3, 4, 2}));
    }
}