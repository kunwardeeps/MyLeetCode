package com.leetcode.solutions;

import java.util.Arrays;

/**https://leetcode.com/problems/3sum-closest/ */
class Problem16{

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1)==-2);
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1)==2);
        System.out.println(threeSumClosest(new int[]{-1, -1, 1, 6, 8}, 1)==-1);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int j=0, k=0, l=nums.length, sum=0, closestSum=100000;
        for (int i=0; i<l-2; i++){
            j = i+1;
            k = l-1;
            while (j<k){
                sum = nums[i]+nums[j]+nums[k];
                if (sum == target){
                    return target;
                }
                else if (sum < target){
                    j++;
                }
                else {
                    k--;
                }
                closestSum = getClosestSum(sum, closestSum, target);
            }
        }
        System.out.println(closestSum);
        return closestSum;
    }

	private static int getClosestSum(int sum, int closestSum, int target) {
        if (Math.abs(sum - target) < Math.abs(closestSum - target)){
            return sum;
        }
		return closestSum;
	}
}