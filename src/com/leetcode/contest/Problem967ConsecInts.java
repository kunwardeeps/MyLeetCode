package com.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem967ConsecInts
 */
public class Problem967ConsecInts {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numsSameConsecDiff(1, 0)));
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> result = new HashSet<>();
        int first = 1;
        if (N == 1) {
            first = 0;
        }
        for (int d = first; d <= 9; d++) {
            recurse(N, K, d, "", result);
        }   
        return result.stream().mapToInt(k->k).toArray();
    }

    public static void recurse(int n, int k, int d, String num, Set<Integer> result) {
        if (num.length() == n) {
            result.add(Integer.parseInt(num));
        }
        else {
            if (d >= 0 && d <= 9) {
                num = num + Integer.toString(d);
                recurse(n, k, d+k, num, result);
                recurse(n, k, d-k, num, result);
            }
        }
    }
}