package com.leetcode.dp;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem322CoinChange
 */
public class Problem322CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {2}, 3));
        System.out.println(coinChange(new int[] {1, 2, 5}, 11) == 3);
        System.out.println(coinChange(new int[] {2}, 3) == -1);
        System.out.println(coinChange(new int[] {1}, 3) == 3);
        System.out.println(coinChange(new int[] {1,2}, 3) == 2);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; 
        List<Integer> list = new ArrayList<>();
        for (int coin: coins) {
            dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            list.clear();
            for (int coin: coins) {
                if (i - coin >= 0) {
                    list.add(dp[i - coin] + 1);
                }
            }
            if (!list.isEmpty()) {
                int min = Collections.min(list);
                if (min == 0) {
                    dp[i] = -1;
                }
                else {
                    dp[i] = min;
                }
            }
            else {
                dp[i] = -1;
            }
        }

        return dp[amount];
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