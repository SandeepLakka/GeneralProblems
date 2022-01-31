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

        val = new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72, 200};
        wt = new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82, 200};
        W = 165;
        n = val.length;
        assertEquals(309, thisObj.knapSackBasicRecursive(wt, val, W, n));

        val = new int[]{};
        wt = new int[]{};
        W = 0;
        n = val.length;
        assertEquals(0, thisObj.knapSackRecurMemoized(wt, val, W, n));

    }

    @Test
    void test_knapSackRecurMemoized() {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        assertEquals(220, thisObj.knapSackRecurMemoized(wt, val, W, n));

        val = new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72, 200};
        wt = new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82, 200};
        W = 165;
        n = val.length;
        assertEquals(309, thisObj.knapSackRecurMemoized(wt, val, W, n));

        val = new int[]{};
        wt = new int[]{};
        W = 0;
        n = val.length;
        assertEquals(0, thisObj.knapSackRecurMemoized(wt, val, W, n));

    }
}