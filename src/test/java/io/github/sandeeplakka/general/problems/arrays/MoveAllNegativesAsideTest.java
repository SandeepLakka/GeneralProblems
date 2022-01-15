package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MoveAllNegativesAsideTest {

    private MoveAllNegativesAside obj;

    @BeforeEach
    public void init() {
        obj = new MoveAllNegativesAside();
    }

    @Test
    @DisplayName("Tests generic cases")
    void tests_moveNegsToSide() {
        assertTrue(test(new int[]{1, 2, -2, 3, 2, -2}, obj.moveNegsToSide(new int[]{1, 2, -2, 3, 2, -2})));
        assertTrue(test(new int[]{12, 3, 443, 34, 1, 2, -2, 3, 2, -2}, obj.moveNegsToSide(new int[]{12, 3, 443, 34, 1, 2, -2, 3, 2, -2})));
        assertTrue(test(new int[]{1, 2, 3, 4, 5, -5, -4, -3, -2, -1}, obj.moveNegsToSide(new int[]{1, 2, 3, 4, 5, -5, -4, -3, -2, -1})));
    }

    @Test
    @DisplayName("Tests all positives or all negatives")
    void testsAllWithSameSign() {
        assertTrue(test(new int[]{1, 2, 3, 4, 5}, obj.moveNegsToSide(new int[]{1, 2, 3, 4, 5})));
        assertTrue(test(new int[]{-1, -2, -3, -4, -5}, obj.moveNegsToSide(new int[]{-1, -2, -3, -4, -5})));
    }

    //Helper
    private static boolean test(int[] original, int[] result) {
        int noOfNegatives = (int) Arrays.stream(original).filter(value -> value < 0).count();
        boolean resultVal = IntStream.range(0, noOfNegatives).map(value -> (result[value] >= 0) ? 1 : 0).sum() == 0;
        return resultVal;
    }
}
