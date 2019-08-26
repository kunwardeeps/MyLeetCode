package com.leetcode.dp;

/**
 * Problem300LIS
 */
public class Problem300LIS {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int curr = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
                max = Math.max(curr, max);
            } else {
                curr = 1;
            }
        }

        return max;
    }
}