package io.github.sandeeplakka.general.problems.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class SUM3V1 {

    //  Driver Code
    public static void main(String[] args) {
        SUM3V1 obj = new SUM3V1();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int sum = 0;
        System.out.println("Naive Approach");
        Arrays.stream(obj.naiveApproach(arr, sum)).map(Arrays::toString).forEach(System.out::println);
        System.out.println("Better Approach");
        System.out.println(obj.betterApproach(arr, sum));
    }
    //classic 3SUM problem but with duplicate elements in input array
    //[-1,0,1,2,-1,-4] with sum = 0 --> [[-1,-1,2],[-1,0,1]]

    public List<List<Integer>> betterApproach(int[] arr, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        int[] sortedArr = IntStream.of(arr).sorted().toArray();
        int index = 0;
        while (index < sortedArr.length) {
            int curVal = sortedArr[index];
            int complement = sum - curVal;
            List<List<Integer>> values = find2SUM(sortedArr, index, index + 1, complement);
            result.addAll(values);
            while (index < sortedArr.length && sortedArr[index] == curVal) {
                index++;
            }
        }
        return result;
    }

    private List<List<Integer>> find2SUM(int[] arr, int root, int startIndex, int sum) {
        Set<Integer> vals = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int index = startIndex;
        while (index < arr.length) {
            int curVal = arr[index];
            int remainingVal = sum - curVal;
            if (vals.contains(remainingVal)) {
                result.add(returnList(arr[root], curVal, remainingVal));
            } else {
                vals.add(curVal);
            }
            while (index < arr.length && arr[index] == curVal) {
                index++;
            }
        }
        return result;
    }

    private List<Integer> returnList(int a, int b, int c) {
        return Arrays.asList(a, b, c);
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
