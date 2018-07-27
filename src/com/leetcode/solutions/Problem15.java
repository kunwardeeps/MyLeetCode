package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**https://leetcode.com/problems/3sum/description/ */
class Problem15{

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        if(nums == null || nums.length<3){
            return sol;
        }
        Arrays.sort(nums);
        int l = nums.length;
        int j = 0;
        int k = 0;
        for (int i=0; i<l-2; i++){
            if(i==0 || nums[i] > nums[i-1]){ //skip if same number
                j = i+1;
                k = l-1;
                while (j<k){
                    if (nums[i]+nums[j]+nums[k]==0){
                        sol.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;

                        while(j<k && nums[j]==nums[j-1]){
                            j++;
                        }
                        while(j<k && nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                    else if (nums[i]+nums[j]+nums[k]<0){
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return sol;
    }
}