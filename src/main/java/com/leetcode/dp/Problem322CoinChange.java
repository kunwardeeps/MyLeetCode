package com.leetcode.dp;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem322CoinChange
 */
public class Problem322CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1, 2, 5}, 11) == 3);
        System.out.println(coinChange(new int[] {2}, 3) == -1);
        System.out.println(coinChange(new int[] {1}, 3) == 3);
        System.out.println(coinChange(new int[] {1,2}, 3) == 2);
    }

    public static int coinChange(int[] coins, int amount) {
        return recurse(coins, amount, 0);
    }

    private static int recurse(int[] coins, int amount, int current) {
        if (amount == current) {
            return 0;
        } else if (amount < current) {
            return -1;
        }

        List<Integer> list = new ArrayList<>();
        for (int coin: coins) {
            int val = recurse(coins, amount, current + coin);
            if (val != -1) {
                list.add(1 + val);
            }
        }

        if (list.isEmpty()) {
            return -1;
        } else {
            return Collections.min(list);
        }
    }
}