package com.leetcode.dp;

/**
 * KnapsackProblem
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        System.out.println(getValue(0, new int[]{10, 20, 30}, new int[]{60, 100, 120}, 0, 50));
    }

    public static int getValue(int i, int[] weightArr, int[] valArr, int weight, int maxWeight) {
        if (i == valArr.length) {
            return 0;
        } else {
            if (weight + weightArr[i] > maxWeight) {
                return getValue(i + 1, weightArr, valArr, weight, maxWeight);
            }
            return Math.max(valArr[i] + getValue(i + 1, weightArr, valArr, weight + weightArr[i], maxWeight), 
                getValue(i + 1, weightArr, valArr, weight, maxWeight));
        }

    }
}