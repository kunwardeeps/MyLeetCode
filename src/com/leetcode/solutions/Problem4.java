package com.leetcode.solutions;

class Problem4{
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{3,5}, new int[]{2,4,6})==4);
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{2})==2.0);
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4})==2.5);
        System.out.println(findMedianSortedArrays(new int[]{1,2,3}, new int[]{4,5})==3);
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2})==1.5);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m+n];
        int i=0, j=0, k=0;
        while (i<m && j<n){
            if (nums1[i] > nums2[j]){
                res[k++] = nums2[j++];
            }
            else {
                res[k++] = nums1[i++];
            }
        }
        while (j<n){
            res[k++] = nums2[j++];
        }
        while (i<m){
            res[k++] = nums1[i++];
        }
        if (k%2==0){
            return ((double)(res[k/2] + res[k/2-1])/2);
        }
        else {
            return (double)(res[k/2]);
        }
    }
}