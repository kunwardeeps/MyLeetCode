package com.leetcode.binarysearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Problem349IntersectingArrays
 */
public class Problem349IntersectingArrays {

    public static void main(String[] args) {
        intersection(new int[] {1,2}, new int[] {3,4});
        intersection(new int[] {1,2,2,1}, new int[] {2,2});
        intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4});
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        for (int num: nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        System.out.println(result);
        return result.stream().mapToInt(i->i).toArray();
    }
}