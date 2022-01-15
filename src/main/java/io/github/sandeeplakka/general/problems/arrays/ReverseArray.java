package io.github.sandeeplakka.general.problems.arrays;

/*
 *
 * Reversing a given array
 */
public class ReverseArray {

    //In-place array reversal
    public int[] reverseArray(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }
        if (arr.length <= 1) return arr;

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            arr[left] ^= arr[right];
            arr[right] ^= arr[left];
            arr[left] ^= arr[right];
            left++;
            right--;
        }
        return arr;
    }
}
