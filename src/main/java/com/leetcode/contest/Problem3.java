package com.leetcode.contest;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(kSub(3, Arrays.asList(1,2,3,4,1)));
    }

    public static long kSub(int k, List<Integer> nums) {
        int [] aux = new int[nums.size()];
        long result = 0;    
        aux[0] = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            aux[i] = aux[i-1] + nums.get(i);
        }
        int[] arr = new int[k];
        for(int i = 0; i < aux.length; i++){       
            int mod = aux[i] % k;
            if(mod == 0) {
                result++;
            }
            result += arr[mod];
            arr[mod]++;
        }
        return result;
    }
    
    


}