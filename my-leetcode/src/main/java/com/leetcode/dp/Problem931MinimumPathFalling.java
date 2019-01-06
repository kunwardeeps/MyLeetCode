package com.leetcode.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.arrays.ArrayHelper;

/**
 * Problem931MinimumPathFalling
 */
public class Problem931MinimumPathFalling {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(ArrayHelper.stringToInt2dArray("[[1,2,3],[4,5,6],[7,8,9]]")));
    }

    public static int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length][A[0].length];
        for (int c = 0; c < A[0].length; c++) {
            dp[0][c] = A[0][c];
        }

        for (int r = 1; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                if (c == 0) {
                    dp[r][c] = A[r][c] + Math.min(dp[r-1][c+1], dp[r-1][c]);
                }
                else if (c == A[0].length - 1) {
                    dp[r][c] = A[r][c] + Math.min(dp[r-1][c-1], dp[r-1][c]);
                }
                else {
                    dp[r][c] = A[r][c] + Math.min(Math.min(dp[r-1][c-1], dp[r-1][c+1]), dp[r-1][c]);
                }
            }
        }
        return Arrays.stream(dp[A.length - 1]).min().getAsInt();
    }

    public static int minFallingPathSumRecursive(int[][] A) {
        List<Integer> result = new LinkedList<>();
        for (int c = 0; c < A[0].length; c++) {
            result.add(recurse(A, 0, c));
        }
        return Collections.min(result);
    }

    private static Integer recurse(int[][] A, int r, int c) {
        if (r >= A.length) {
            return 0;
        }
        if (c == 0) {
            return A[r][c] + Math.min(recurse(A, r+1, c), recurse(A, r+1, c+1));
        }
        if (c == A[0].length-1) {
            return A[r][c] + Math.min(recurse(A, r+1, c), recurse(A, r+1, c-1));
        }
        return A[r][c] + Math.min(Math.min(recurse(A, r+1, c), recurse(A, r+1, c-1)), recurse(A, r+1, c+1));
    }
}