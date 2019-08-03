package com.leetcode.binarysearch;

/**
 * Problem852PeakIndex
 */
public class Problem852PeakIndex {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] {0,1,0}) == 1);
        System.out.println(peakIndexInMountainArray(new int[] {0,2,1,0}) == 1);
    }

    public static int peakIndexInMountainArray(int[] A) {
        return search(A, 0, A.length-1);
    }

    private static int search(int[] a, int l, int r) {
        int m = (l + r) / 2;
        if (a[m] > a[m-1] && a[m] > a[m+1]) {
            return m;
        }
        else if (a[m] > a[m-1] && a[m] < a[m+1]) {
            return search(a, m+1, r);
        }
        else {
            return search(a, l, m-1);
        }
    }
}