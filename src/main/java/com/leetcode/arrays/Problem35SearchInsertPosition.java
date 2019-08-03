package com.leetcode.arrays;

/**
 * Problem35SearchInsertPosition
 */
public class Problem35SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {}, 0) == 0);
        System.out.println(searchInsert(new int[] {1}, 1) == 0);
        System.out.println(searchInsert(new int[] {1}, 0) == 0);
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5) == 2);
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2) == 1);
        System.out.println(searchInsert(new int[] {1,3,5,6}, 7) == 4);
        System.out.println(searchInsert(new int[] {1,3,5,6}, 0) == 0);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return recurse(nums, 0, nums.length - 1, target);
    }

    private static int recurse(int[] nums, int l, int r, int target) {
        if (l < r) {
            int m = (l + r)/2;
            if (nums[m] > target) {
                return recurse(nums, l, m - 1, target);
            }
            else if (nums[m] < target) {
                return recurse(nums, m + 1, r, target);
            } 
            else {
                return m;
            }
        }
        else {
            if (target <= nums[l]) {
                return l;
            }
            else {
                return r + 1;
            }
        }
    }
}