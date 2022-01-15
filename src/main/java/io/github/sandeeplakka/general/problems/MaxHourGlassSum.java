package io.github.sandeeplakka.general.problems;

import java.util.List;
import java.util.Objects;

public class MaxHourGlassSum {

    /**
     * Returns the maximum hour glass sum in the given array
     * <p>
     * An hourglass is a subset of values with indices falling
     * in this pattern in arrays's graphical representation:
     * <pre>
     * a b c
     *   d
     * e f g
     * </pre>
     * for ex. there will be 16 hour glasses in the array of size 6X6
     * Throws IllegalArgumentException if the input is not valid
     * Invalid inputs are either null values or empty values
     *
     * @param list Input matrix
     * @return maximum hour glass sum in the input
     */
    public int getMaxHourGlassSum(List<List<Integer>> list) {
        if (list == null || list.stream().filter(Objects::isNull).findAny().isPresent()) {
            throw new IllegalArgumentException("Input list contents must not be null");
        }
        if (list.size() == 0 || list.stream().anyMatch(List::isEmpty)) {
            throw new IllegalArgumentException("Input list rows must not be empty");
        }
        print(list);
        int max = Integer.MIN_VALUE;
        int rows = list.size();
        int cols = list.get(0).size();
        for (int col = 0; col < cols - 2; col++) {
            for (int row = 0; row < rows - 2; row++) {
                int sum = getSum(list, col, row);
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    private int getSum(List<List<Integer>> list, int col, int row) {
        int sum = 0;
        sum += list.get(row).get(col) + list.get(row).get(col + 1) + list.get(row).get(col + 2);
        sum += list.get(row + 1).get(col + 1);
        sum += list.get(row + 2).get(col) + list.get(row + 2).get(col + 1) + list.get(row + 2).get(col + 2);
        return sum;
    }

    private void print(List<List<Integer>> list) {
        for (List<Integer> row : list) {
            StringBuilder sb = new StringBuilder();
            for (int point : row) {
                sb.append(String.format("%s ", point));
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }
}
