package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem784Permutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("abc"));
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
        System.out.println(letterCasePermutation(""));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.isEmpty()){
            result.add("");
            return result;
        }
        recurse(S.toLowerCase(), 0, result);
        return result;
    }

    private static void recurse(String s, int i, List<String> result) {
        result.add(s);
        int j = 0;
        for (j = i; j < s.length(); j++) {
            if (Character.isLowerCase(s.charAt(j))){
                String s1 = capitalize(s, j);
                recurse(s1, j+1, result);
            }
        }
    }

    private static String capitalize(String s, int i) {
        char[] arr = s.toCharArray();
        arr[i] = Character.toUpperCase(arr[i]);
        return new String(arr);
    }
}