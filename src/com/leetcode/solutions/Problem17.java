package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/ */
class Problem17{

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("9"));
        System.out.println(letterCombinations("586927"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer, String> dict = new HashMap<>();
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");

        List<String> output = new ArrayList<>();
        if (digits.isEmpty()){
            return output;
        }
        recurse("", 0, dict, digits, output);
        return output;
    }

    public static void recurse(String s, int i, 
        Map<Integer, String> dict, String digits, List<String> output){
        if (i == digits.length()){
            output.add(s.toString());
            return;
        }
        String pattern = dict.get(Character.getNumericValue(digits.charAt(i)));
        for (int j=0; j<pattern.length(); j++){
            recurse(s+pattern.charAt(j), i+1, dict, digits, output);
        }
    }

}