package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortO12sTest {

    private SortO12s sortO12s;

    @BeforeEach
    public void init() {
        sortO12s = new SortO12s();
    }

    @Test
    @DisplayName("Tests possible cases")
    public void testsPossible() {
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 2, 2, 2},
                sortO12s.sortArray(new int[]{1, 2, 0, 1, 2, 1, 0, 2}));
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2},
                sortO12s.sortArray(new int[]{1, 0, 2, 1, 0, 1, 2, 1, 2}));
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1},
                sortO12s.sortArray(new int[]{1, 1, 1, 1, 1, 1, 1}));
        assertArrayEquals(new int[]{1, 1, 1, 1, 2, 2, 2, 2},
                sortO12s.sortArray(new int[]{1, 2, 1, 2, 1, 2, 1, 2}));
        assertNull(sortO12s.sortArray(null));
        assertNull(sortO12s.sortArray(new int[]{}));
    }

}