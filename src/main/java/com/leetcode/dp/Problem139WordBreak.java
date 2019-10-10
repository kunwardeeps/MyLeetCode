package com.leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * Problem139WordBreak
 */
public class Problem139WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakDp(s, wordDict);
        //return recurse(s, wordDict, s.length());
    }

    private static boolean wordBreakDp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private static boolean recurse(String s, List<String> wordDict, int i) {
        if (wordDict.contains(s.substring(0, i))) {
            return true;
        } else {
            for (int j = 1; j < i; j++) {
                if (recurse(s.substring(0, j), wordDict, j) && wordDict.contains(s.substring(j, i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreakFirstAttempt(String s, List<String> wordDict) {
        int start = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                start = i;
            } else if (i == s.length()) {
                return false;
            }
        }
        return true;
    }
}