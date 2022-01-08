package io.github.sandeeplakka.general.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestContinuousArraySumTest {

    private LargestContinuousArraySum largestContinuousArraySum;

    @BeforeEach
    public void init() {
        largestContinuousArraySum = new LargestContinuousArraySum();
    }

    @Test
    @DisplayName("Test regular good cases")
    public void testsPositiveCases() {
        assertEquals(7, largestContinuousArraySum.getLargestContiguousSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }

    @Test
    @DisplayName("Test regular bad cases")
    public void testsBadCases() {
        assertEquals(-1, largestContinuousArraySum.getLargestContiguousSum(new int[]{}));
    }

    @Test
    @DisplayName("Test regular good cases")
    public void testsExceptionalCases() {
        assertThrows(IllegalArgumentException.class, () -> largestContinuousArraySum.getLargestContiguousSum(null));
    }

}