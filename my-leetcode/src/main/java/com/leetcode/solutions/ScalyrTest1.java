package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScalyrTest1 {
    public static void main(String[] args) {
        
    }

    public static void reciprocal(int N) {
        // Write your code here
        String result = "";

        long num = 1, d = N;

        long resultNumeric = num / d;
        result += Long.toString(resultNumeric);

        long rem = (num % d) * 10;
        if (rem == 0) {
            System.out.println(result + " 0");
        }

        Map<Long, Integer> hashMap = new HashMap<>();
        result += ".";
        while (rem != 0) {
            if (hashMap.containsKey(rem)) {
                int beg = hashMap.get(rem);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg);
                result = part1 + part2 + " " + part2;
                System.out.println(result);
                return;
            }

            hashMap.put(rem, result.length());
            resultNumeric = rem / d;
            result += Long.toString(resultNumeric);
            rem = (rem % d) * 10;
        }

        System.out.println(result + "0 0");
    }

	
}