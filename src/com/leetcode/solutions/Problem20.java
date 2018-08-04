package com.leetcode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**https://leetcode.com/problems/valid-parentheses/description/ */
class Problem20{
    public static void main(String[] args) {
        System.out.println(isValid("]")==false);
        System.out.println(isValid("()")==true);
        System.out.println(isValid("()[]{}")==true);
        System.out.println(isValid("(]")==false);
        System.out.println(isValid("([)]")==false);
        System.out.println(isValid("{[]}")==true);
        System.out.println(isValid("")==true);
        System.out.println(isValid("{")==false);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        char c = ' ';
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<s.length(); i++){
            c = s.charAt(i);
            if (map.containsKey(c)){
                stack.add(c);
            }
            else if (stack.isEmpty()){
                return false;
            }
            else if (c == map.get(stack.peek())){
                stack.pop();
            }
            else {
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isValidEfficient(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else {
                    stack.push('}');
                }
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}