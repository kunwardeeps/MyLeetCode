package com.leetcode.contest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Problem5364TargetArray
 */
public class Problem5364TargetArray {

    public boolean hasValidPath(int[][] grid) {
        Map<Integer, int[][]> map = new HashMap<>();
        int[][] one = {{}, {}, {1,4,6}, {1,3,5}};
        int[][] two = {{2,3,4}, {2,5,6}, {}, {}};
        int[][] three = {{}, {2,5,6}, {1,4,6}, {}};
        int[][] four = {{}, {2,5,6}, {}, {1,3,5}};
        int[][] five = {{2,3,4}, {}, {1,4,6}, {}};
        int[][] six = {{2,3,4}, {}, {}, {1,3,5}};
        map.put(1, one);
        map.put(2, two);
        map.put(3, three);
        map.put(4, four);
        map.put(5, five);
        map.put(6, six);

        return recurse(grid, map);
    }

    private boolean recurse(int[][] grid, Map<Integer, int[][]> map) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
            }
        }
        return false;
    }
}