package com.leetcode.dp;

/**
 * Problem70ClimbingSteps
 */
public class Problem70ClimbingSteps {

    public static void main(String[] args) {
        System.out.println(climbStairs(2) == 2);
        System.out.println(climbStairs(3) == 3);
        System.out.println(climbStairs(4) == 5);
    }

    public static int climbStairsOptimizedSpace(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int climbStairsRecursive(int n) {
        return recurse(0, n);
    }

    public static int recurse(int current, int steps){
        if (current == steps){
            return 1;
        }
        else if (current > steps){
            return 0;
        }
        return recurse(current+1, steps) + recurse(current+2, steps);
    }
}