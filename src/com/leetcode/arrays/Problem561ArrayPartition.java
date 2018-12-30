package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Problem561ArrayPartition
 */
public class Problem561ArrayPartition {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[] {-1,-2,0,1}) == -2);
        System.out.println(arrayPairSum(new int[] {-1,-2,-3,-4}) == -6);
        System.out.println(arrayPairSum(new int[] {}) == 0);
        System.out.println(arrayPairSum(new int[] {4,3,2,1}) == 4);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}