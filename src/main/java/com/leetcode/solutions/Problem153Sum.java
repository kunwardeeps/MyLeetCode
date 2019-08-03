package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**https://leetcode.com/problems/3sum/description/ */
class Problem153Sum{

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> triplet = null;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            triplet = new ArrayList<>();;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    result.add(triplet);
                    triplet = new ArrayList<>();;
                    l++;
                    r--;
                }
                else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }
                else {
                    r--;
                }

            }
        }
        return result;
    }
}