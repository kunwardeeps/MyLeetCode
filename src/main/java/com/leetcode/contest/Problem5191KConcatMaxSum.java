package com.leetcode.contest;

/**
 * Problem5191KConcatMaxSum
 */
public class Problem5191KConcatMaxSum {

    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[] {Integer.MAX_VALUE}, 10));
        System.out.println(kConcatenationMaxSum(new int[] {Integer.MAX_VALUE}, 1));
        System.out.println(kConcatenationMaxSum(new int[] {1,-2,1}, 5));
        System.out.println(kConcatenationMaxSum(new int[] {-1,-2}, 7));
        System.out.println(kConcatenationMaxSum(new int[] {1,2}, 3));
    }

    public static int kConcatenationMaxSum(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return 0;
        }
        int mod = (int) (Math.pow(10, 9)) + 7;

        int max = 0;
        int maxSoFar = 0;
        int l = 2;
        int sum = 0;

        while (l > 0) {
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = (sum + arr[i]) % mod;
                max = Math.max((max + arr[i]) % mod, arr[i]);
                maxSoFar = Math.max(max, maxSoFar);
            }
            l--;
        }

        if (maxSoFar == 2 * sum) {
            return k * sum;
        } else {
            return maxSoFar;
        }
    }
}