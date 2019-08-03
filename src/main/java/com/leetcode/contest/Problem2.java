package com.leetcode.contest;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem2
 */
public class Problem2 {

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[] {3,2,4,1}));
        System.out.println(pancakeSort(new int[] {1,2,3}));
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new LinkedList<>();
        int[] maxArr = new int[2];
        int lastMax = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            findNumLessThan(A, maxArr, i, lastMax);
            lastMax = maxArr[0];
            if (maxArr[1] == A.length - i - 1) {
                continue;
            }
            moveMaxTo(A, maxArr, A.length - i - 1, result);
        }
        return result;
    }

    private static void findNumLessThan(int[] A, int[] maxArr, int j, int lastMax) {
        maxArr[0] = 0;
        for (int i = 0; i < A.length - j; i++) {
            if (A[i] > maxArr[0] && A[i] < lastMax) {
                maxArr[0] = A[i];
                maxArr[1] = i;
            }
        }
    }

    private static void moveMaxTo(int[] A, int[] maxArr, int lastIdx, List<Integer> result) {
        if (maxArr[1] == 0) {
            flip(A, lastIdx);
            result.add(lastIdx + 1);
        }
        else {
            flip(A, maxArr[1]);
            flip(A, lastIdx);
            result.add(maxArr[1] + 1);
            result.add(lastIdx + 1);
        }
    }

    private static void flip(int[] A, int idx) {
        for (int i = 0; i < (idx+1)/2; i++) {
            swap(A, i, idx - i);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}