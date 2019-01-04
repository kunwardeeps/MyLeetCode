package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Problem905OddEven
 */
public class Problem905OddEven {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {2,4,3,1})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {2,2,2,2})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {1,1,1,1})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {1})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {2})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {})));
        System.out.println(Arrays.toString(sortArrayByParity(new int[] {3,1,2,4})));
    }

    public static int[] sortArrayByParity(int[] A) {
        int j = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                swap(A, i, j + 1);
                j++;
            }
        }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}