package com.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SubstringProblem
 */
public class SubstringProblem1 {

    public static void main(String[] args) {
        System.out.println(getSubstrings("awaglk", 4));
    }

    public static List<String> getSubstrings(String s, int n) {
        List<String> result = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length()-n; i++) {
            charSet.clear();

            for (int j = i; j < n+i; j++) {
                charSet.add(s.charAt(j));
            }
            if (charSet.size() == n-1) {
                result.add(s.substring(i, i+n));
            }
        }
        return result;
    }
}