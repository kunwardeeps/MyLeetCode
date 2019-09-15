package com.leetcode.contest;

import java.util.Stack;

/**
 * Problem5190ReverseString
 */
public class Problem5190ReverseString {

    public static void main(String[] args) {
        System.out.println(reverseParentheses("a((bcd))"));
        System.out.println(reverseParentheses("a()(bcd)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(abcd)"));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        for (Character c: s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (int i = 0; i < sb.length(); i++) {
                    stack.push(sb.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            output.insert(0, stack.pop());
        }
        return output.toString();
    }
}