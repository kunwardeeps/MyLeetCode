package com.leetcode.dp;

import java.util.Arrays;

/**
 * Problem198HouseRobber
 */
public class Problem198HouseRobber2 {

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,3,1,3,100}));
        System.out.println(rob(new int[] {2,1,1,2}));
        System.out.println(rob(new int[] {2,3,2}));
        System.out.println(rob(new int[] {1,2,3,1}));
        System.out.println(rob(new int[] {2,7,9,3,1}));
        System.out.println(rob(new int[] {}) == 0);
        System.out.println(rob(new int[] {1}) == 1);
        System.out.println(rob(new int[] {1,2}) == 2);
    }

    public static int rob(int[] nums) {
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(nums[0] + recurseDp(nums, 2, true, dp1), recurseDp(nums, 1, false, dp2));
    }

    private int iterativeDp(int[] nums, boolean robFirst){
        // edge case
        if(nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length+1];
        
        // initial condition
        dp[0] = 0;
        dp[1] = robFirst ? nums[0]: 0;
        
        // iteration
        for(int i = 2; i < dp.length; i++){
            if(i!=dp.length-1){ 
                // normal case
                dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
            }else{
                // last robbery
                dp[i] = robFirst ? dp[i-1] : Math.max(dp[i-2]+nums[i-1], dp[i-1]);
            }
        }
        
        return dp[dp.length-1];

    }

    public static int recurseDp(int[] nums, int i, boolean firstPicked, int[] dp) {
        if (firstPicked && i == nums.length - 1) {
            return 0;
        }
        if (i > nums.length - 1) {
            return 0;
        } else if (dp[i] >= 0) {
            return dp[i];
        } else {
            dp[i] = Math.max(nums[i] + recurseDp(nums, i + 2, firstPicked, dp), recurseDp(nums, i + 1, firstPicked, dp));
            return dp[i];
        }
    }

    public static int recurse(int[] nums, int i, boolean firstPicked) {
        if (firstPicked && i == nums.length - 1) {
            return 0;
        }
        if (i > nums.length - 1) {
            return 0;
        } else {
            if (i == 0) {
                firstPicked = true;
            }
            return Math.max(nums[i] + recurse(nums, i + 2, firstPicked), recurse(nums, i + 1, false));
        }
    }
}