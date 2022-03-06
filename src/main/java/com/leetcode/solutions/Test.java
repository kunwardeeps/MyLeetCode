package com.leetcode.solutions;

import java.math.BigInteger;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.activity.InvalidActivityException;

class Interval {
    int start;
    int end;
    int idx;

    Interval(int start, int end, int idx) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    @Override
    public String toString() {
        return this.start + "," + this.end;
    }
}

public class Test {

    static List<String> combinations = new ArrayList<>();
    static int i = 0;

    public static void main(String[] args) {
        // create object of De1ue
        Deque<Integer> DQ = new LinkedList<Integer>();

        // Add numbers to end of Deque
        DQ.offerLast(1);
        DQ.offerLast(2);
        DQ.offerLast(3);
        DQ.offerLast(4);

        // before removing print Deque
        System.out.println("Deque: " + DQ);
        System.out.println("peek: " + DQ.peek());
        System.out.println("peekFirst: " + DQ.peekFirst());
        System.out.println("peekLast: " + DQ.peekLast());
        System.out.println("poll: " + DQ.poll());
    }

    public int[] findRightInterval(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        String s;
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1], i));
        }
        Arrays.asList(intervals);

        try {
            TreeMap<Integer, Integer> map = new TreeMap<>();
        } catch (Exception e) {

        }

        StringBuilder sb = new StringBuilder();
        System.out.println(list);
        return null;

    }

    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, lsize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }

        map.values().stream().collect(Collectors.toList());

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.get(sum - target) != null) {
                lsize = Math.min(lsize, i - map.get(sum - target));
            }
            // hmap.get(sum+target) searches for any sub-array starting with index i+1 with sum target.
            if (map.get(sum + target) != null && lsize < Integer.MAX_VALUE) {
                // updates the result only if both left and right sub-array exists.
                result = Math.min(result, map.get(sum + target) - i + lsize);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void recurse(String str, int l, int i, String current) {
        if (current.length() == l) {
            combinations.add(current);
            return;
        }
        if (i >= str.length() || str.length() - i < l - current.length())
            return;

        recurse(str, l, i + 1, current + Character.toString(str.charAt(i)));
        recurse(str, l, i + 1, current);

    }
}
