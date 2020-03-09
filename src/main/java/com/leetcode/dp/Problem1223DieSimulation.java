package com.leetcode.dp;

/**
 * Problem1223DieSimulation
 */
public class Problem1223DieSimulation {

    public int dieSimulator(int n, int[] rollMax) {
        return recurse(n, 0, 0, rollMax, 0);
    }
    
    public int recurse(int n, int idx, int consecTimes, int[] rollMax, int totLen) {
        if (n == totLen) {
            return 1;
        }
        
        int total = 0;
        for (int i = 0; i < 6; i++) {
            if (idx == i && consecTimes < rollMax[i]) {
                total += recurse(n, i, consecTimes + 1, rollMax, totLen + 1);
            } else if (idx != i) {
                total += recurse(n, i, 1, rollMax, totLen + 1);
            }
        }
        return total;
    }
}