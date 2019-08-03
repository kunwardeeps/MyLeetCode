package com.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem5018CamelCase
 */
public class Problem5018CamelCase {

    public static void main(String[] args) {
        System.out.println(camelMatch(new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB"));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String str: queries) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < sb.length(); i++) {
                if (!Character.isUpperCase(sb.charAt(i))) {
                    sb.deleteCharAt(i--);
                }
            }
            result.add(sb.toString().equals(pattern));
        }
        return result;
    }
}