package com.leetcode.string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem804UniqueWords
 */
public class Problem804UniqueWords {

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> result = new HashSet<>();
        for (String word: words) {
            result.add(transform(word));
        }
        return result.size();
    }

    private static String transform(String word) {
        String[] values = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        char[] keys = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, String> map = IntStream.range(0, 26).boxed()
            .collect(Collectors.toMap(i -> keys[i], i -> values[i]));

        StringBuilder sb = new StringBuilder();

        for (Character c: word.toCharArray()) {
            sb.append(map.get(c));
        }
        return sb.toString();
    }
}