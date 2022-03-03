package io.github.sandeeplakka.general.problems.arrays;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Examples:

Input: nums = [1,3,4,2,2]       -->     Output: 2
Input: nums = [3,1,3,4,2]       -->     Output: 3



Constraints:

    1 <= n <= 105
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.

 */
public class FindDuplicateNumber {

    //Naive way using O(N) space with linear time complexity
    public int getDuplicate(int[] nums) {
        boolean[] isVisited = new boolean[nums.length];
        for (int val : nums) {
            if (isVisited[val]) return val;
            if (!isVisited[val]) isVisited[val] = true;
        }
        return -1;
    }

    public int getDuplicateWithSet(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int val : nums) {
            if (visited.contains(val)) return val;
            visited.add(val);
        }
        return -1;
    }
}
