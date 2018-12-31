package com.leetcode.dp;

/**
 * Problem338CountingBits
 */
public class Problem338CountingBits {

    public static void main(String[] args) {
        System.out.println(getOnes(7));
    }

    public static int[] countBits(int num) {
        return null;
    }

    public static int getOnes(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
}