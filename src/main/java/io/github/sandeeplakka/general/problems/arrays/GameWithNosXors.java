package io.github.sandeeplakka.general.problems.arrays;

public class GameWithNosXors {

    //Need to return array with items as xors of consecutive elems
    //in input array in which last elem stays the same
    public int[] game_with_number(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            res[i] = arr[i] ^ arr[i + 1];
        }
        res[n - 1] = arr[n - 1];
        return res;
    }
}
