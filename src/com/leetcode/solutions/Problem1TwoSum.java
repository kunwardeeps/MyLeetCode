package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.algos.QuickSort;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Problem1TwoSum {

    public static void main(String[] args) {

        int[] input = new int[]{2, 7, 11, 15};
        printArray(input);
        int[] output = solution2(input, 9);
        printArray(output);

    }

    private static int[] solution1(int[] input, int target) {
        int[] out = new int[2];
        int r = input.length-1;
        QuickSort.sort(input, 0, r);
        int j = 0;
        for (int i=0; i<=r; i++){
            j = binarySearch(input, i+1, r, target - input[i]);
            if (j != -1){
                out[0] = i;
                out[1] = j;
                return out;
            }
        }
        return out;
    }

    private static int binarySearch(int[] input, int l, int r, int number) {
        int mid = (l+r)/2;
        if (r >= l){
            if (input[mid] > number){
                return binarySearch(input, l, mid, number);
            }
            if (input[mid] == number){
                return mid;
            }
            if (input[mid] < number){
                return binarySearch(input, mid, r, number);
            }
        }
        return -1;

	}

	private static int[] solution2(int[] input, int target) {
        int[] out = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<input.length; i++){
            if (map.containsKey(input[i])){
                out[0] = map.get(input[i]);
                out[1] = i;
            }
            else {
                map.put(target - input[i], i);
            }
        }
        return out;
    }

    private static int[] naiveSolution(int[] input, int target) {
        int j = 0;
        int[] out = new int[2];
        for (int i=0; i<input.length; i++){
            for (j=i+1; j<input.length; j++){
                if (input[i] + input[j] == target){
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    private static void printArray(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int x: arr){
            sb.append(x);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
