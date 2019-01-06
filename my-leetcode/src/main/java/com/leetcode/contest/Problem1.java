package com.leetcode.contest;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem1
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(90, 100, 1000000));
        System.out.println(powerfulIntegers(1, 2, 100));
        System.out.println(powerfulIntegers(2, 3, 0));
        System.out.println(powerfulIntegers(2, 3, 10));
        System.out.println(powerfulIntegers(3, 5, 15));
        System.out.println(powerfulIntegers(5, 3, 15));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result = new LinkedList<>();

        for (int val = 2; val <= bound; val++) {
            if (numExists(x, y, val, bound)) {
                result.add(val);
            }
        }
        return result;
    }

    private static boolean numExists(int x, int y, int val, int bound) {
        int result = 0, i = 0, j = 0;
        for (i = 0; i <= bound; i++) {
            for (j = 0; j <= bound; j++) {
                result = compute(x, y, i, j);
                if (result == val) {
                    return true;
                }
                if ((result > bound || result > val) && j == 0) {
                    return false;
                }
                if (result > bound || result > val) {
                    break;
                }
            }
        }
        return false;
    }

    private static int compute(int x, int y, int i, int j) {
        return (int) (Math.pow(x, i) + Math.pow(y, j));
    }


}