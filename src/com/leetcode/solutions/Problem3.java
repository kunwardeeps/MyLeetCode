package com.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.geometry.Side;

/**
 * Problem3:
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Problem3 {

    public static void main(String[] args) {
        String s = "abcd";
        int length = s.length();
        int max = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i=0; i<length; i++){
            max = Math.max(max, getLength(s, i, length-1, charSet));
        }
        System.out.println(max);
    }

    private static int getLength(String input, int st, int end, Set<Character> charSet){
        charSet.clear();
        for (int i = st; i <= end; i++){
            if (charSet.contains(input.charAt(i))){
                return i-st;
            }
            else if (i == end){
                return i-st+1;
            }
            else {
                charSet.add(input.charAt(i));
            }
        }
        return 1;//default
    }
    
}