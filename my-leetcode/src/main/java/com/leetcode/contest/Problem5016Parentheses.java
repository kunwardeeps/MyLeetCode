package com.leetcode.contest;

import java.util.Stack;

/**
 * Problem5016Parentheses
 */
public class Problem5016Parentheses {

    public static void main(String[] args) {
        int x = (int) (Math.pow(10, 9) + 7);
        System.out.println(x);
        // System.out.println(removeOuterParentheses("(()())(())"));
        // System.out.println(removeOuterParentheses("()()"));
    }

    public static String removeOuterParentheses(String S) {

        if (S.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        int start = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '('){
                stack.add(S.charAt(i));
            }
            else {
                stack.pop();
            }
            if (stack.empty() && i != 0) {
                result.append(S.substring(start + 1, i));
                start = i + 1;
            }
        }
        return result.toString();
        
    }
}