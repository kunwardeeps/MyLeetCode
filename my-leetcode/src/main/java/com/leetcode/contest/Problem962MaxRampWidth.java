package com.leetcode.contest;

/**
 * Problem962MaxRampWidth
 */
public class Problem962MaxRampWidth {

    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[] {6,0,8,2,1,5}));
        System.out.println(maxWidthRamp(new int[] {9,8,1,0,1,9,4,0,4,1}));
        System.out.println(maxWidthRamp(new int[] {1,1,1}));
        System.out.println(maxWidthRamp(new int[] {9,8,7,6}));
    }

    public static int maxWidthRamp(int[] A) {
        int maxWidth = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if (maxWidth > A.length - 1 - i){
                    break;
                }
                if (A[j] >= A[i]) {
                    maxWidth = Math.max(maxWidth, j - i);
                }
            }
        }
        return maxWidth;
    }
}