package com.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem5189MaxBalloons
 */
public class Problem5189MaxBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balon"));
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
        System.out.println(maxNumberOfBalloons(""));
    }

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> balloonMap = new HashMap<>();
        int minCount = Integer.MAX_VALUE;
        
        for (Character c: text.toCharArray()) {
            if ("balloon".contains(Character.toString(c))){
                int count = balloonMap.getOrDefault(c, 0);
                balloonMap.put(c, count + 1);
            }
        }

        for (Character c: "balloon".toCharArray()) {
            if (c == 'l' || c == 'o') {
                minCount = Math.min(minCount, balloonMap.getOrDefault(c, 0)/2);
            } else {
                minCount = Math.min(minCount, balloonMap.getOrDefault(c, 0));
            }
        }

        return minCount == Integer.MAX_VALUE? 0: minCount;
    }
}