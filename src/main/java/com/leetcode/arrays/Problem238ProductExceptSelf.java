package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Problem238ProductExceptSelf
 */
public class Problem238ProductExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,1,1})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        l[0] = 1;
        r[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = l[i] * r[i];
        } 

        return nums;
    }
}