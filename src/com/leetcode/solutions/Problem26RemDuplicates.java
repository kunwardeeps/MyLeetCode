package com.leetcode.solutions;

import java.util.Arrays;

/**
 * Problem26RemDuplicates
 */
public class Problem26RemDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {}));
        System.out.println(removeDuplicates(new int[] {0,0,0}));
        System.out.println(removeDuplicates(new int[] {0,1,2}));
        System.out.println(removeDuplicates(new int[] {0,1,1,1,2,2,2,3}));
        System.out.println(removeDuplicates(new int[] {0,1,1,2}));
    }

    /**
     * Optimized solution
     * j iterates whole array
     * i keeps track of new array last position updates only when change is encountered
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //shitty attempt
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int j=0;
        int count = 0;
        for (int i=0; i<nums.length; i++){
            j=i+1;
            while(j<nums.length && nums[i] == nums[j] && nums[i] != Integer.MAX_VALUE){
                j++;
                count++;
            }
            //If duplicate found, then shift rest elements
            if (j>i+1){
                int k = i+1;
                while (j< nums.length){
                    nums[k] = nums[j];
                    k++;
                    j++;
                }
                while (k < nums.length){
                    nums[k] = Integer.MAX_VALUE;
                    k++;
                }
            }
        }
        //printArray(nums);
        return nums.length - count;
    }

    private static void printArray(int[] nums) {
        Arrays.stream(nums).forEach(num -> System.out.print(num+","));
        System.out.println();
    }
}