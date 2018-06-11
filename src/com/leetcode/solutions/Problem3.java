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
        System.out.println(solution2("abcd")==4);
        System.out.println(solution2("dcdf")==3);
        System.out.println(solution2("a")==1);
        System.out.println(solution2("ab")==2);
        System.out.println(solution2("bbbb")==1);
        System.out.println(solution2("pwwkew")==3);
        System.out.println(solution2("abcabcbb")==3);
    }

    /**
     * Sliding window O(n) solution
     * https://www.youtube.com/watch?v=sZosU8JjVaA
     */
    public static int solution2(String s){
        int st = 0, max=0, e=0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (e=0; e<s.length(); e++){
            if (charMap.containsKey(s.charAt(e))){
                max = Math.max(max, e-st);
                if (charMap.get(s.charAt(e))+1 >= st){
                    st = charMap.get(s.charAt(e))+1;
                }
            }
            charMap.put(s.charAt(e), e);
        }
        return Math.max(max, e-st);
    }

    /**
     * O(n^2) solution
     */
    public static int solution1(String s){
        int length = s.length();
        int max = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i=0; i<length; i++){
            max = Math.max(max, getLength(s, i, length-1, charSet));
            if (max == length-i){
                return max;//no need to proceed as rest are unique
            }
        }
        return max;
    }

    private static int getLength(String input, int st, int end, Set<Character> charSet){
        charSet.clear();
        for (int i = st; i <= end; i++){
            if (charSet.contains(input.charAt(i))){
                return i-st;
            }
            else if (i == end){// case when all unique
                return i-st+1;
            }
            else {
                charSet.add(input.charAt(i));
            }
        }
        return 1;//default
    }
    
}