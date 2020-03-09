package com.leetcode.dp;

import java.util.Arrays;

/**
 * Problem416CanPartition
 */
public class Problem416CanPartition {

    public boolean canPartition(int[] nums) {
        Integer sum = Arrays.stream(nums).sum();
        return recurse(nums, 0, sum/2, 0);
    }

    private boolean recurse(int[] nums, int curr, int target, int i) {
        if (curr == target) {
            return true;
        } else {
            if (i >= nums.length) return false;
            return recurse(nums, curr + nums[i], target, i + 1) ||
                recurse(nums, curr, target, i + 1);
        }
    }
}