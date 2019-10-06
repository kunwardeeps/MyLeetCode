package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.leetcode.arrays.ArrayHelper;

/**
 * Problem57InsertIntervals
 */
public class Problem57InsertIntervals {

    public static void main(String[] args) {
        System.out.println(insert(ArrayHelper.stringToInt2dArray("[[1,3],[6,9]]"), ArrayHelper.stringToIntegerArray("[2,5]")));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> listIntervals = new LinkedList<>();
        List<List<Integer>> overlappingIntervals = new LinkedList<>();

        for (int[] interval: intervals) {
            listIntervals.add(Arrays.stream(interval).boxed().collect(Collectors.toList()));
        }

        

        for (List<Integer> interval: listIntervals) {
            if (newInterval[0] >= interval.get(0) && newInterval[0] <= interval.get(1)) {

            }
        }
        return null;
    }
}