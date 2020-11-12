package com.paypal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProblemLoungeStocking {
    static int max = -1;

    public static void main(String[] args) {
        System.out.println(stockLounge(Arrays.asList(0,1,1), Arrays.asList(0,0,0,2,2,2), 2));
        //System.out.println(stockLounge(new int[] {0,2,2}, new int[] {2,0,0}, 2));
    }

    public static int stockLounge(List<Integer> onHand, List<Integer> supplier, int demand) {
        Collections.sort(onHand);
        Collections.sort(supplier);
        recurse(onHand, supplier, 0, 0, 0, 0, demand);
        return max;
    }

    public static void recurse(List<Integer> onHand, List<Integer> supplier, int i, int j, int day, int total, int demand) {
        if (j >= supplier.size()) {
            max = Math.max(max, total);
            return;
        }
        int onHandConsumed = 0;
        while (i < onHand.size() && day == onHand.get(i)) {
            onHandConsumed++;
            i++;
        }
        if (onHandConsumed > demand) return;

        int required = demand - onHandConsumed;
        if (i < onHand.size()) {
            recurse(onHand, supplier, i + required, j, day + 1, total, demand);
        } else {
            int k = 1;
            while (j + k < supplier.size() && supplier.get(j + k) >= day){
                k++;
            }
            recurse(onHand, supplier, i, j + k, day + 1, total + k, demand);
            return;
        }
        for (int k = 1; k <= required && j + k < supplier.size(); k++) {
            if (supplier.get(j + k) >= day) {
                recurse(onHand, supplier, i + required - k, j + k, day + 1, total + k, demand);
            } else {
                j++;
            }
        }
    }

    private static void recurse1(int[] onHand, int[] supplier, int i, int j, int day, int total, int demand) {
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