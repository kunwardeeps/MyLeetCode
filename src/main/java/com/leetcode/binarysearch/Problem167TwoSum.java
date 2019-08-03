package com.leetcode.binarysearch;

import java.util.Arrays;

/**
 * Problem167TwoSum
 */
public class Problem167TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int search = -1;
        for (int i = 0; i < numbers.length; i++) {
            search = binarySearch(numbers, 0, numbers.length, target - numbers[i]);
            if (search != -1) {
                result[0] = i+1;
                result[1] = search+1;
                return result;
            }
        }
        return null;
    }

    public static int binarySearch(int[] arr, int l, int r, int target) {
        int m = (l + r) / 2;
        if (m<=l || m >= r) {
            return -1;
        }
        if (arr[m] == target) {
            return m;
        }
        else {
            if (arr[m] > target) {
                return binarySearch(arr, l, m, target);
            }
            else {
                return binarySearch(arr, m, r, target);
            }
        }
    }
}