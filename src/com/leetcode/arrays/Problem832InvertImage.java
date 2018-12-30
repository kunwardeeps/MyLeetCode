package com.leetcode.arrays;

/**
 * Problem832InvertImage
 */
public class Problem832InvertImage {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            flipRow(A, i);
            invertRow(A, i);
        }
        return A;
    }

    private static void invertRow(int[][] A, int i) {
        for (int j = 0; j < A[0].length; j++) {
            A[i][j] = A[i][j] == 0? 1: 0;
        }
    }

    private static void flipRow(int[][] A, int i) {
        for (int j = 0; j < A[0].length/2; j++) {
            swap(A, i, j, A[0].length - 1 - j);
        }
    }

    private static void swap(int[][] A, int r, int j, int k) {
        int temp = A[r][j];
        A[r][j] = A[r][k];
        A[r][k] = temp;
    }


    
}