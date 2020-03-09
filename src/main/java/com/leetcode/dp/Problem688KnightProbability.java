package com.leetcode.dp;

/**
 * Problem688KnightProbability
 */
public class Problem688KnightProbability {

    class Result {
        public int pathsOnBoard = 0;
        public int pathsOutside = 0;
    }

    public static void main(String[] args) {
        
    }

    public double knightProbability(int N, int K, int r, int c) {
        Result result = new Result();
        recurse(N, K, r, c, result);
        return (double) result.pathsOnBoard / (result.pathsOnBoard + result.pathsOutside);
    }

    private void recurse(int n, int k, int r, int c, Result result) {
        if (r > n - 1 || c > n - 1) {
            result.pathsOutside += 1;
            return;
        } else if (k == 0) {
            result.pathsOnBoard += 1;
        }
        recurse(n, k - 1, r + 2, c + 1, result);
        recurse(n, k - 1, r + 1, c + 2, result);
        recurse(n, k - 1, r - 1, c + 2, result);
        recurse(n, k - 1, r - 2, c + 1, result);
        recurse(n, k - 1, r - 2, c - 1, result);
        recurse(n, k - 1, r - 1, c - 2, result);
        recurse(n, k - 1, r + 1, c - 2, result);
        recurse(n, k - 1, r + 2, c - 1, result);
    }
}