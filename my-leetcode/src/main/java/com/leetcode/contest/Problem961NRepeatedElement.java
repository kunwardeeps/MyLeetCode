package com.leetcode.contest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Problem961NRepeatedElement
 */
public class Problem961NRepeatedElement {

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[] {1,2,3,3}) == 3);
        System.out.println(repeatedNTimes(new int[] {5,1,5,2,5,3,5,4}) == 5);
        System.out.println(repeatedNTimes(new int[] {1}) == 1);
    }

    public static int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: A){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}