package com.leetcode.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem819UniqueWords
 */
public class Problem819UniqueWords {

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Long> frequency = Arrays.stream(words).collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String mostCommonWord = frequency.entrySet().stream()
            .filter(e -> !bannedList.contains(e.getKey().toLowerCase()))
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .findFirst().map(e -> e.getKey())
            .get();
        return mostCommonWord;
    }
}