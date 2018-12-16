package com.leetcode.dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 */
public class Problem746 {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}) == 15);
        System.out.println(minCostClimbingStairs(new int[] {}) == 0);
        System.out.println(minCostClimbingStairs(new int[] {3}) == 3);
        System.out.println(minCostClimbingStairs(new int[] {1,3}) == 1);
        System.out.println(minCostClimbingStairs(new int[] {3,1}) == 1);
        System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}) == 6);
    }

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i=2; i<cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * Naive O(2^n)
     * @param cost
     * @return
     */
    public static int minCostClimbingStairsRecursive(int[] cost) {
        if (cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }
        return Math.min(recurse(cost, 0), recurse(cost, 1));
    }

    public static int recurse(int[] a, int i){
        if (i == a.length-1){
            return a[i];
        }
        else if (i == a.length){
            return 0;
        }

        return a[i] + Math.min(recurse(a, i+1), recurse(a, i+2));
        
    }
}