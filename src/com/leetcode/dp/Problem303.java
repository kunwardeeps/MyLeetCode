package com.leetcode.dp;

/**
 * Problem303
 */
public class Problem303 {

    static int dp[][] = null;

    public static void main(String[] args) {
        numArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(sumRange(0,2) == 1);
        System.out.println(sumRange(2,5) == -1);
        System.out.println(sumRange(0,5) == -3);
    }

    public static void numArray(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (j == i) {
                    dp[i][j] = nums[i];
                }
                else {
                    dp[i][j] = dp[i][j-1] + nums[j];
                }
            }
        }
    }
    
    public static int sumRange(int i, int j) {
        return dp[i][j];
    }
}