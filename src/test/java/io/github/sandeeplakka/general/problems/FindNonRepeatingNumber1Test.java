package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNonRepeatingNumber1Test {

    private FindNonRepeatingNumber1 findNonRepeatingNumber1;

    @BeforeEach
    public void init() {
        findNonRepeatingNumber1 = new FindNonRepeatingNumber1();
    }

    @Test
    @DisplayName("Tests regular/good scenarios")
    void testsGoodCases() {
        assertEquals(1, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{1, 2, 3, 2, 3}));
        assertEquals(-1, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{3, 2, -1, 2, 3}));
        assertEquals(10, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{10, 20, 10, 20, 10}));
    }

    @Test
    @DisplayName("Tests regular/bad scenarios")
    void testsBadCases() {
        assertEquals(Integer.MIN_VALUE, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{1, 1, 2, 2}));
        assertEquals(Integer.MIN_VALUE, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{0, 0, 2, 2}));
        assertEquals(Integer.MIN_VALUE, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{-2, 0, -2, 0}));
    }

    @Test
    @DisplayName("Tests exceptional scenarios")
    void testsExceptionals() {
        assertThrows(IllegalArgumentException.class,
                () -> findNonRepeatingNumber1.getNonRepeatingNumber(null));
        assertEquals(Integer.MIN_VALUE, findNonRepeatingNumber1.getNonRepeatingNumber(new int[]{}));

    }
}