package io.github.sandeeplakka.general.problems.arrays;

import java.util.*;

public class SUM3V1 {

//  Driver Code
//    public static void main(String[] args) {
//        SUM3V1 obj = new SUM3V1();
//        int[] arr = {-1,0,1,2,-1,-4};
//        int sum = 0;
//        Arrays.stream(obj.naiveApproach(arr, sum)).map(Arrays::toString).forEach(System.out::println);
//    }
    //classic 3SUM problem but with duplicate elements in input array
    //[-1,0,1,2,-1,-4] with sum = 0 --> [[-1,-1,2],[-1,0,1]]

    //TODO better approach ( <n^3 time complexity ) implementation
    public Set<String> betterApproach(int[] arr, int sum) {
        return null;
    }

    public int[][] naiveApproach(int[] arr, int sum) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        int highest = Math.max(arr[i], Math.max(arr[j], arr[k]));
                        int lowest = Math.min(arr[i], Math.min(arr[j], arr[k]));
                        int middle = sum - (highest + lowest);
                        result.add(String.format("%d,%d,%d", lowest, middle, highest));
                    }
                }
            }
        }
        int[][] ints = new int[result.size()][3];
        int index = 0;
        for (String value : result) {
            ints[index++] = Arrays.stream(value.split(",")).mapToInt(Integer::parseInt).toArray();
        }
        return ints;
    }
}
