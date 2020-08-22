package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test{

    static List<String> combinations = new ArrayList<>();
    static int i = 0;
    public static void main(String[] args) {
        //System.out.println(solution(new int []{1,2,3,4,5}));
        recurse("abcd", 3, 0, "");
        System.out.println(combinations);
    }
    
    public static void recurse(String str, int l, int i, String current) {
        if (current.length() == l) {
            combinations.add(current);
            return;
        }
        if (i >= str.length() || str.length() - i < l - current.length()) return;
        
        recurse(str, l, i + 1, current + Character.toString(str.charAt(i)));
        recurse(str, l, i + 1, current);
        
    }
}