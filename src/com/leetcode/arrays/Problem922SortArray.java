package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Problem922SortArray
 */
public class Problem922SortArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[] {4,2,5,7})));
    }

    /**
     * Better approach: Initialize even and odd and avoid checking indices
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
            int[] val = new int[A.length];
            int even = 0;
            int odd = 1;
    
            for (int i = 0; i < len; i++) {
                if((A[i] & 1) == 0)
                {
                    val[even] = A[i];
                    even += 2;
                }else {
                    val[odd] = A[i];
                    odd += 2;
                }
            }
    
            return val;
        }

    public static int[] sortArrayByParityIInaive(int[] A) {
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] % 2 == 0) {
                    continue;
                }
                else {
                    j = i+1;
                    while (A[j] % 2 != 0) {
                        j++;
                    }
                    swap(A, i, j);
                }
            }
            else {
                if (A[i] % 2 != 0) {
                    continue;
                }
                else {
                    j = i+1;
                    while (A[j] % 2 == 0) {
                        j++;
                    }
                    swap(A, i, j);
                }
            }
        }
        return A;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}