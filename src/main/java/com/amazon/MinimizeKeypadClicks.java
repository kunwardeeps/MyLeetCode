package com.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimizeKeypadClicks {
    public static void main(String[] args) {
        System.out.println(minimizeClicks("hello"));
        System.out.println(minimizeClicks("abcghdiefjoba"));
    }

    public static int minimizeClicks(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // System.out.println(map.toString());

        List<Integer> counts = map.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        // System.out.println(counts);

        int clicks = 0;
        for (int i = 0; i < counts.size(); i++) {
            if (i < 9) {
                clicks += counts.get(i);
            } else if (i >= 9 && i < 18) {
                clicks += 2 * counts.get(i);
            } else {
                clicks += 3 * counts.get(i);
            }
        }
        return clicks;
    }
}