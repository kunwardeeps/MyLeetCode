package com.leetcode.dp;

/**
 * Problem62UniquePaths
 */
public class Problem62UniquePaths {

    public static void main(String[] args) {
        System.out.println();
    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return recurse(1, 1, m, n);
    }



    private int recurse(int i, int j, int m, int n) {
        if (i > m || j > n) {
            return 0;
        }
        if (i == m && j == n) {
            return 1;
        }
        return recurse(i + 1, j, m, n) + recurse(i, j + 1, m, n);
    }
}