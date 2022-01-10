package io.github.sandeeplakka.general.problems.arrays;

import java.util.Arrays;

/*
 *
 * Sort an array containings only 0,1 and 2s
 */
public class SortO12s {


    public static int[] sortArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        int left = 0;
        int mid = 0;
        int right = arr.length - 1;
        while (mid <= right) {
            if (arr[mid] == 0) {
                swap(arr, left, mid);
                mid++;
                left++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, right);
                right--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
