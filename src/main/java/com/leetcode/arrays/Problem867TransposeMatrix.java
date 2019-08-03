package com.leetcode.arrays;

/**
 * Problem867TransposeMatrix
 */
public class Problem867TransposeMatrix {

    public static void main(String[] args) {
        System.out.println(ArrayHelper.int2dArrayToString(transpose(ArrayHelper.stringToInt2dArray("[[]]"))));
        System.out.println(ArrayHelper.int2dArrayToString(transpose(ArrayHelper.stringToInt2dArray("[[1,2,3],[4,5,6]]"))));
        System.out.println(ArrayHelper.int2dArrayToString(transpose(ArrayHelper.stringToInt2dArray("[[1,2,3],[4,5,6],[7,8,9]]"))));
    }

    public static int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}