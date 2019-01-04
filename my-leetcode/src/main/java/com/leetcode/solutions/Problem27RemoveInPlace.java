package com.leetcode.solutions;

import java.util.Arrays;

/**
 * Problem26RemoveInPlace
 */
public class Problem27RemoveInPlace {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {}, 0));
        System.out.println(removeElement(new int[] {1,1,1}, 1));
        System.out.println(removeElement(new int[] {0,0,0}, 1));
        System.out.println(removeElement(new int[] {0,1,2}, 1));
        System.out.println(removeElement(new int[] {0,1,1,1,2,2,2,3}, 2));
        System.out.println(removeElement(new int[] {0,1,1,2}, 1));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int i=0;
        for (int j=0; j<nums.length; j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        printArray(nums);
        return i;
    }

    private static void printArray(int[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.print(num+","));
        System.out.println();
    }
}