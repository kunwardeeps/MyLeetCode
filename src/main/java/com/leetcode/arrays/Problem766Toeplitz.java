package com.leetcode.arrays;

/**
 * Problem766Toeplitz
 */
public class Problem766Toeplitz {

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(ArrayHelper.stringToInt2dArray("[[1,2,3,4],[5,1,2,3],[9,5,1,2]]")) == true);
        System.out.println(isToeplitzMatrix(ArrayHelper.stringToInt2dArray("[[1,2],[2,2]]")) == false);
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] != matrix[r-1][c-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isToeplitzMatrix1(int[][] matrix) {
        for (int r = 0; r < matrix.length-1; r++) {
            if (!isDiagonalUniform(matrix, r, 0)) {
                return false;
            }
        }
        for (int c = 1; c < matrix[0].length-1; c++) {
            if (!isDiagonalUniform(matrix, 0, c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDiagonalUniform(int[][] matrix, int r, int c) {
        int val = matrix[r][c];
        while (r < matrix.length && c < matrix[0].length) {
            if (val != matrix[r][c]) {
                return false;
            }
            else {
                r++;
                c++;
            }
        }
        return true;
    }
}