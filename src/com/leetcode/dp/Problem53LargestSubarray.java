package com.leetcode.dp;

/**
 * Problem53LargestSubarray
 */
public class Problem53LargestSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {6}) == 6);
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}) == 6);
        System.out.println(maxSubArray(new int[] {-1,-2,-1,0,5,6,8,-2,-3}) == 19);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i=1; i<nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static int maxSubArrayBad(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<nums.length; j++){
                sum=0;
                for (int k=j; k<i+j && k<nums.length; k++){
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}