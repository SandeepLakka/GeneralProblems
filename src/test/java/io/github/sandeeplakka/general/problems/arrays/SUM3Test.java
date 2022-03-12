package io.github.sandeeplakka.general.problems.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SUM3Test {

    private SUM3 underTest;

    @BeforeEach
    public void init() {
        underTest = new SUM3();
    }

    @Test
    void findSubArrays() {
        int[] arr = new int[]{1, 2, 45, 10, 8, 4, 6, 5};
        int sum = 13;
        assertTrue(isEquals(new HashSet<>(Arrays.asList("(1,2,10)", "(1,4,8)", "(2,5,6)")),
                underTest.findSubArrays(arr, sum)));
    }

    private boolean isEquals(Set<String> expected, Set<String> actual) {
        return (expected.containsAll(actual) && actual.size() == expected.size());
    }
}