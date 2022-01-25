package io.github.sandeeplakka.general.problems.arrays;

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
}
