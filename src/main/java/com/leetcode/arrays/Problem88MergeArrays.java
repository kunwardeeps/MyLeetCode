package com.leetcode.arrays;

/**
 * Problem88MergeArrays
 */
public class Problem88MergeArrays {

    public static void main(String[] args) {
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while (i >= 0) {
            nums1[k] = nums1[i];
            k--;
            i--;
        }
        while (j >= 0) {
            nums1[k] = nums1[j];
            k--;
            j--;
        }
    }
}