package com.amazon;

import java.util.HashSet;
import java.util.Set;

public class MaxDiscountPairs {
    public static void main(String[] args) {
        System.out.println(getMaxDiscountPairs(new int[] {2,1,8}));
    }

    public static int getMaxDiscountPairs(int[] nums) {
        int pairs = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            for (int i = 1; i < 15; i++) {
                if (set.contains((3 ^ i) - num)) {
                    pairs++;
                }
            }
            set.add(num);
        }
        return pairs;
    }
}
