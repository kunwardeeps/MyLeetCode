package com.leetcode.arrays;

import java.util.Arrays;

/**
 * Problem957HashTable
 */
public class Problem957HashTable {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        
        int current = cells[0];
        int prev = current;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < cells.length; i++) {
                if (i == 0 || i == cells.length - 1) {
                    cells[i] = 0;
                    prev = cells[i];
                    continue;
                }
                current = cells[i];
                if (prev == cells[i + 1]) {
                    cells[i] = 1;
                } else {
                    cells[i] = 0;
                }
                prev = current;
            }
        }
        
        return cells;
    }
}