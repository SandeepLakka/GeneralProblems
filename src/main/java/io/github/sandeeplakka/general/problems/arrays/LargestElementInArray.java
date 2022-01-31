package io.github.sandeeplakka.general.problems.arrays;

import java.util.Arrays;

public class LargestElementInArray {

    /**
     * Returns the largest element in the array arr
     *
     * @param arr Array of integers
     * @param n   length of array
     * @return largest element in array arr of integers
     */
    public int largest(int[] arr, int n) {
        //Same as IntStream as the arr is array of ints
        return Arrays.stream(arr).max().orElse(-1);
    }
}
