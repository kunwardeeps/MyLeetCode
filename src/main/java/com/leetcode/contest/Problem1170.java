package com.leetcode.contest;

/**
 * Problem1170
 */
public class Problem1170 {

    public static void main(String[] args) {
        String s = "aaaa";
        char min = s.charAt(0);
        int minCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < min) {
                min = s.charAt(i);
                minCount = 1;
            } else if (s.charAt(i) == min) {
                minCount++;
            }
        }
        System.out.println(minCount);
    }
}