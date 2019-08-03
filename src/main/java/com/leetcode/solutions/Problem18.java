package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** https://leetcode.com/problems/4sum/description/ */
class Problem18{

    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {-1,0,-5,-2,-2,-4,0,1,-2}, -9));
        System.out.println(fourSum(new int[] {-1,0,1,2,-1,-4}, -1));
        System.out.println(fourSum(new int[] {1, 0, -1, 0}, 0));
        System.out.println(fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSum(new int[] {1, 0, -1, 0}, 1));
        System.out.println(fourSum(new int[] {1, 0, -1, 0, 1}, 1));
        System.out.println(fourSum(new int[] {-1, 0, -1, 0, 1}, -1));
        System.out.println(fourSum(new int[] {1, 0, -1}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int i=0,j=0,l=0,r=0,sum=0;
        int len=nums.length;
        if (len<4){
            return result;
        }

        Arrays.sort(nums);

        for (i=0; i<len-3; i++){
            if (i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for (j=i+1; j<len-2; j++){
                if (j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                l=j+1;
                r=len-1;
                while (l<r){
                    sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                        while (l<r && nums[l]==nums[l-1]){
                            l++;
                        }
                        while (l<r && nums[r]==nums[r+1]){
                            r--;
                        }
                    }
                    else if (sum < target){
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
    
        return result;
    }
}