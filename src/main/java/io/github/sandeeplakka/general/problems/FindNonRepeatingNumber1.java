package io.github.sandeeplakka.general.problems;

import java.util.Objects;
import java.util.stream.IntStream;

public class FindNonRepeatingNumber1 {

    /**
     * Returns the number which either does not repeat or repeats odd number
     * of times from the given array of integers <b>array</b>
     * Returns Integer.MIN_VALUE if there's no repeating number in the array.
     *
     * @param array array of numbers in which to find the non repeating number
     *              (if any)
     * @return non repeating number if exists in array or Integer.MIN_VALUE
     */
    public int getNonRepeatingNumber(final int[] array) {
        if (Objects.isNull(array)) {
            throw new IllegalArgumentException("Array must not be null");
        }
        if (array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int nonRepeating = 0;
        nonRepeating = IntStream.of(array)
                .reduce((left, right) -> left ^ right).getAsInt();
        if (nonRepeating == 0) {
            return Integer.MIN_VALUE;
        }
        return nonRepeating;
    }
}
