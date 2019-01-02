package com.leetcode.dp;

import java.util.Arrays;

/**
 * Problem338CountingBits
 */
public class Problem338CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    //Efficient
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        f[0] = 0;
        for (int i = 1; i <= num; i++) {
            f[i] = f[i / 2] + (i & 1);
        }
        return f;
    }

    public static int[] countBits1(int num) {
        int[] dp = new int[num+1];

        for (int i = 1; i <= num; i++) {
            dp[i] = getOnes(i);
        }

        return dp;
    }

    // O(n*size(int))
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