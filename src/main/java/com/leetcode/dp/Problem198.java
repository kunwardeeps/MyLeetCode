package com.leetcode.dp;

import java.util.Arrays;

/**
 * Problem198
 */
public class Problem198 {

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,1,1,2}));
        System.out.println(rob(new int[] {1,2}));
        System.out.println(rob(new int[] {1}));
        System.out.println(rob(new int[] {}));
        System.out.println(rob(new int[] {1,2,3,1}));
        System.out.println(rob(new int[] {2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        return dpRecurse(nums, 0, dp);
    }

    public static int dpIterative(int[] nums, int start, int[] dp) {
        if (nums.length == 0) return 0;
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i+1] = Math.max(dp[i], dp[i-1] + val);
        }
        return dp[nums.length];
    }


    public static int dpRecurse(int[] nums, int i, int[] dp) {
        if (i > nums.length - 1) {
            return 0;
        } else if (dp[i] >= 0) {
            return dp[i];
        } else {
            dp[i] = Math.max(nums[i] + dpRecurse(nums, i + 2, dp), dpRecurse(nums, i + 1, dp));
            return dp[i];
        }
    }

    public static int recurse(int[] nums, int i) {
        if (i > nums.length - 1) {
            return 0;
        } else {
            return Math.max(nums[i] + recurse(nums, i + 2), recurse(nums, i + 1));
        }
    }
}