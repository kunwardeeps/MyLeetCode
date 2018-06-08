package com.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem3:
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Problem3 {

    public static void main(String[] args) {
        String s = "dvdf";

        String longest = "";
        String substr = "";
        Set<Character> charSet = new HashSet<>();

        int st=0;
        int e=0;

        for (e = 0; e < s.length(); e++ ){
            if (charSet.contains(s.charAt(e))){
                substr = s.substring(st,e);
                if (substr.length() > longest.length()){
                    longest = substr;
                }
                st = e;
                charSet = new HashSet<>();
                charSet.add(s.charAt(st));
            }
            else {
                charSet.add(s.charAt(e));
            }
        }

        if (charSet.size()>longest.length()){
            longest = s.substring(st,e);
        }

        System.out.println(longest);
    }
    
}