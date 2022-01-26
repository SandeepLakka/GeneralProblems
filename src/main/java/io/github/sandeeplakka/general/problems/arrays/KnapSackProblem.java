package io.github.sandeeplakka.general.problems.arrays;

import java.util.Arrays;

public class KnapSackProblem {

    //classic 0-1 Knapsack problem implementation
    //Basic recursive solution
    public int knapSackBasicRecursive(int[] wt, int[] val, int W, int n) {
        //Basecase
        if (n == 0 || W == 0) {
            return 0;
        }
        //If weight is more than knap sack capacity, no need to
        //Consider this, try others
        if (wt[n - 1] > W) {
            return knapSackBasicRecursive(wt, val, W, n - 1);
        }
        //If the weight of this item is less or equals to available
        //weight in knap sack then take the maximum of below cases
        return Math.max(
                //What happens if we take this into our knapSack
                val[n - 1] + knapSackBasicRecursive(wt, val, W - wt[n - 1], n - 1),
                //What happens if we don't take this
                knapSackBasicRecursive(wt, val, W, n - 1)
        );
    }


    //classic 0-1 Knapsack problem implementation
    //Memoized version of recursive solution
    public int knapSackRecurMemoized(int[] wt, int[] val, int W, int n) {
        //memo object
        int[][] memo = new int[n + 2][W + 2];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        return knapSackRecurMemoized(wt, val, W, n, memo);
    }

    private int knapSackRecurMemoized(int[] wt, int[] val, int W, int n, int[][] memo) {
        //base case
        if (n == 0 || W == 0) {
            return 0;
        }
        if (memo[n][W] != -1) {
            return memo[n][W];
        }
        if (wt[n - 1] > W) {
            memo[n][W] = knapSackBasicRecursive(wt, val, W, n - 1);
            return memo[n][W];
        }
        memo[n][W] = Math.max(
                //What happens if we take this into our knapSack
                val[n - 1] + knapSackBasicRecursive(wt, val, W - wt[n - 1], n - 1),
                //What happens if we don't take this
                knapSackBasicRecursive(wt, val, W, n - 1)
        );
        return memo[n][W];

    }
}
