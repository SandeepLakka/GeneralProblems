package io.github.sandeeplakka.general.problems;

import java.util.Objects;

public class LargestContinuousArraySum {

    /**
     * Returns the largest sum of contiguous sub array in a given array
     * Returns -1 if the array is empty
     * Throws IllegalArgumentException if the input is null
     *
     * @param arr array of integers of negative and non-negative numbers
     * @return largest sum of contiguous sub array
     */
    public int getLargestContiguousSum(int[] arr) {
        if (Objects.isNull(arr)) throw new IllegalArgumentException("Input array must not be null");
        int curSum = 0;
        int maxSum = -1;
        for (int val : arr) {
            curSum += val;
            if (curSum < val) curSum = val;
            if (curSum > maxSum) maxSum = curSum;
        }
        return maxSum;
    }

}
