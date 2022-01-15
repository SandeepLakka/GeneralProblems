package io.github.sandeeplakka.general.problems.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
    Move all negatives to the left of array
 */
public class MoveAllNegativesAside {

    public int[] moveNegsToSide(int[] arr) {
        //System.out.println("\nOriginal array is "+Arrays.toString(arr));
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (arr[left] < 0 && left < arr.length - 1) left++;
            while (arr[right] >= 0 && right > 0) right--;
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        //System.out.println("Array with negatives moved left : "+Arrays.toString(arr));
        return arr;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
