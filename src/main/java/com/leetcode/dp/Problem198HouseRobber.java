package com.leetcode.dp;

import java.util.Arrays;

/**
 * Problem198HouseRobber
 */
public class Problem198HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,1,1,2}) == 4);
        System.out.println(rob(new int[] {1,2,3,1}) == 4);
        System.out.println(rob(new int[] {2,7,9,3,1}) == 12);
        System.out.println(rob(new int[] {}) == 0);
        System.out.println(rob(new int[] {1}) == 1);
        System.out.println(rob(new int[] {1,2}) == 2);
    }

    /*Better formulation */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i >= 2) {
                dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            } else {
                dp[i] = Math.max(nums[i], dp[i-1]);
            }
        }
        return dp[nums.length-1];
    }

    public static int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length]; 
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(nums[1], nums[0] + nums[2]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static int robRecursive(int[] nums) {
        return Math.max(recurse(nums, 0), recurse(nums, 1));
    }

    private static int recurse(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return nums[i] + Math.max(recurse(nums, i+2), recurse(nums, i+3));
    }
}