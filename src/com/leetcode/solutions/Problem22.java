package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/generate-parentheses/description/ */
class Problem22{
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(0));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParanthesis(n, result, 0, 0, "");
        return result;
    }

    private static void generateParanthesis(int n, List<String> result, 
    int open, int close, String str) {
        if (close == n){
            result.add(str);
        }    
        else {
            if (open > close){
                generateParanthesis(n, result, open, close+1, str+")");
            }
            if (open < n){
                generateParanthesis(n, result, open+1, close, str+"(");
            }
        }
    }
    
    /**Using StringBuilder with backtracking */
    private void build(int leftBalance, int rightBalance, int currentBalance, StringBuilder sb, List<String> result) {
        if (leftBalance == 0 && rightBalance == 0) {
            result.add(sb.toString());
            return;
        }
        if (currentBalance > 0) {
            sb.append(')');
            build(leftBalance, rightBalance - 1, currentBalance - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            if (leftBalance > 0) {
                sb.append('(');
                build(leftBalance - 1, rightBalance, currentBalance + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append('(');
            build(leftBalance - 1, rightBalance, currentBalance + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}