package com.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SubstringProblem
 */
public class SubstringProblem {

    public static void main(String[] args) {
        System.out.println(getSubstrings("adfgkg", 4));
    }

    public static List<String> getSubstrings(String s, int n) {
        List<String> result = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            charSet.clear();

            for (int j = i; j < s.length(); j++) {
                charSet.add(s.charAt(j));
                if (charSet.size() == n) {
                    result.add(s.substring(i, j+1));
                }
            }
        }
        return result;
    }
}