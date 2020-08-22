package com.paypal;

import java.util.Arrays;

public class ProblemLoungeStocking {
    static int max = -1;

    public static void main(String[] args) {
        System.out.println(stockLounge(new int[] {0,1,1,1,2,2}, new int[] {0,1,1,1,1,1}, 2));
        System.out.println(stockLounge(new int[] {0,2,2}, new int[] {2,0,0}, 2));
    }

    public static int stockLounge(int[] onHand, int[] supplier, int demand) {
        Arrays.sort(onHand);
        Arrays.sort(supplier);
        recurse(onHand, supplier, 0, 0, 0, 0, demand);
        return max;
    }

    private static void recurse(int[] onHand, int[] supplier, int i, int j, int day, int total, int demand) {
        if (i >= onHand.length) {
            max = Math.max(max, total);
            return;
        }
        int onHandConsumed = 0;
        while (i < onHand.length && day == onHand[i]) {
            onHandConsumed++;
            i++;
        }
        if (onHandConsumed > demand) return;

        int required = demand - onHandConsumed;
        recurse(onHand, supplier, i + required, j, day + 1, total, demand);
        for (int k = 1; k <= required && j + k < supplier.length; k++) {
            if (supplier[j + k] >= day) {
                recurse(onHand, supplier, i + required - k, j + k, day + 1, total + k, demand);
            } else {
                j++;
            }
        }
    }
}