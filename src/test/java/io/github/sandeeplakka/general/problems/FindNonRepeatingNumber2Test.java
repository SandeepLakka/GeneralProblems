package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNonRepeatingNumber2Test {

    private FindNonRepeatingNumber2 findNonRepeatingNumber2;

    @BeforeEach
    public void init() {
        findNonRepeatingNumber2 = new FindNonRepeatingNumber2();
    }

    @Test
    @DisplayName("Tests regular positive cases")
    public void testsPositives() {
        assertArrayEquals(new int[]{1, 2}, findNonRepeatingNumber2.getNonRepeatingNumbers(new int[]{1, 2, 3, 3, 2, 1, 2, 1}));
        assertArrayEquals(new int[]{-2, 2}, findNonRepeatingNumber2.getNonRepeatingNumbers(new int[]{1, -2, 2, 3, 1, 3}));
    }

    @Test
    @DisplayName("Tests regular negative cases")
    public void testsNegatives() {
        assertArrayEquals(new int[]{0, 1}, findNonRepeatingNumber2.getNonRepeatingNumbers(new int[]{1, 2, 2, 3, 3}));
        assertArrayEquals(new int[]{0, 0}, findNonRepeatingNumber2.getNonRepeatingNumbers(new int[]{1, 2, 2, 3, 3, 1}));
        assertArrayEquals(new int[]{0, 0}, findNonRepeatingNumber2.getNonRepeatingNumbers(new int[]{}));
        assertArrayEquals(new int[]{0, 3}, findNonRepeatingNumber2.getNonRepeatingNumbers(new int[]{3}));
    }

    @Test
    @DisplayName("Tests exceptionals")
    public void testsExceptions() {
        assertThrows(IllegalArgumentException.class,
                () -> findNonRepeatingNumber2.getNonRepeatingNumbers(null));
    }
}