package com.leetcode.arrays;

/**
 * Problem48RotateMatrix
 */
public class Problem48RotateMatrix {

    public static void main(String[] args) {
        rotate(ArrayHelper.stringToInt2dArray(""));
    }

    public static void rotate(int[][] matrix) {
        int l = matrix[0].length;
        if (l == 0) {
            return;
        }
        int temp = 0;
        reverseRows(matrix);
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseRows(int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[l - i - 1];
            matrix[l - i - 1] = temp;
        }
    }
}