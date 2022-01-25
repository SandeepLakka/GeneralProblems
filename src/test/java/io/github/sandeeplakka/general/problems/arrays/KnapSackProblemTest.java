package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapSackProblemTest {

    private KnapSackProblem thisObj;

    @BeforeEach
    public void init() {
        thisObj = new KnapSackProblem();
    }

    @Test
    @DisplayName("Testing basic recursive implementation of knapSack")
    void test_knapSackBasicRecursive() {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        assertEquals(220, thisObj.knapSackBasicRecursive(wt, val, W, n));
    }
}