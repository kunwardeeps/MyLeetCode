package com.leetcode.dp;

/**
 * Problem494TargetSum
 */
public class Problem494TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        return recurse(nums, 0, 0, S);
    }

    private int recurse(int[] nums, int i, int current, int S) {
        if (i == nums.length && current == S) {
            return 1;
        } else if (i == nums.length && current != S) {
            return 0;
        }
        return recurse(nums, i + 1, current + nums[i], S) +
            recurse(nums, i + 1, current - nums[i], S);
    }


}