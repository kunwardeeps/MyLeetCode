package com.leetcode.dp;

/**
 * Problem1155
 */
public class Problem1155 {

    public static void main(String[] args) {
        
    }

    public int numRollsToTarget(int d, int f, int target) {
        return recurse(d, f, target, 0);
    }

    private int recurse(int d, int f, int target, int current) {
        if (current == target) {
            return 1;
        }

        if (current > target || d <= 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i <= f; i++) {
            sum += recurse(d - 1, f, target, current + i);
        }

        return sum;
    }
}