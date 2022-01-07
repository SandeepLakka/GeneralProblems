package io.github.sandeeplakka.general.problems;

import java.util.Objects;
import java.util.stream.IntStream;

public class FindNonRepeatingNumber2 {

    /**
     * Returns two numbers which either does not repeat or repeats odd number
     * of times from the given array of integers <b>array</b>
     * Returns null if there's no repeating numbers in the array.
     * Return 0 as substitute for one of the numbers in
     * output pair if there doesn't exist such
     * e.g : [1, 1, 2, 2, 1] returns [1, 0]
     * [1, 1, 2, 2] returns [0, 0]
     *
     * @param array array of numbers in which to find the non repeating number
     *              (if any)
     * @return array of non repeating number if exists in array or
     * 0 substituted for missing number
     */
    public int[] getNonRepeatingNumbers(final int[] array) {

        if (Objects.isNull(array)) {
            throw new IllegalArgumentException("Array must not be null");
        }
        if (array.length == 0) return new int[]{0, 0};
        int nonRepeating = 0;
        nonRepeating = IntStream.of(array)
                .reduce(nonRepeating, (left, right) -> left ^ right);
        if (0 == nonRepeating) return new int[]{0, 0};

        int setBit = getFirstSetBit(nonRepeating);
        int val1 = IntStream.of(array).filter(value -> isBitSet(value, setBit))
                .reduce(nonRepeating, (left, right) -> left ^ right);
        int val2 = nonRepeating ^ val1;
        return new int[]{Math.min(val1, val2), Math.max(val1, val2)};

    }

    private boolean isBitSet(int value, int bit) {
        return (value & bit) != bit;
    }

    private int getFirstSetBit(int value) {
        return Integer.lowestOneBit(value);
    }
}
