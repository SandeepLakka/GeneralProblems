package io.github.sandeeplakka.general.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class SUM3 {
    //Find all the pairs in given array 'arr' which sums to the value 'sum'
    //[1, 2, 45, 10, 8, 4, 6, 5] --> (1,2,10), (1,4,8), (2,5,6)
    Set<String> findSubArrays(int[] arr, int sum) {
        //map -> (value, index)
        Set<String> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int k : arr) {
            set.add(k);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int remaining = sum - (arr[i] + arr[j]);
                if (set.contains(remaining) && (remaining != arr[i] && remaining != arr[j])) {
                    int highest = Math.max(arr[i], Math.max(arr[j], remaining));
                    int lowest = Math.min(arr[i], Math.min(arr[j], remaining));
                    int middle = sum - highest - lowest;
                    result.add(String.format("(%d,%d,%d)", lowest, middle, highest));
                }
            }
        }
        return result;
    }
}
