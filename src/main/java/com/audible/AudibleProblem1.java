package com.audible;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * AudibleProblem1
 */
public class AudibleProblem1 {

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        int maxLength = Collections.max(lengths);
        int current = 0;

        for (int i = 1; i <= maxLength; i++) {
            current = Math.max(current, getPrice(i, costPerCut, salePrice, lengths));
        }
        return current;
     }
 
     private static int getPrice(Integer i, int costcut, int price, List<Integer> lengths) {
         int cuts = 0;
         int parts = 0;
         for (int len : lengths) {
             if (len == i) {
                 parts++;
             } else {
                 parts = parts + len / i;
             }
             if (len % i == 0) {
                 cuts = cuts + len / i - 1;
             } else {
                 cuts = cuts + len / i;
             }
         }
 
         return price * parts * i - cuts * costcut;
     }
}