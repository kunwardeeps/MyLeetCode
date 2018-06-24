package com.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

class Problem13{
    public static void main(String[] args) {
        System.out.println(romanToInt("III")==3);
        System.out.println(romanToInt("IV")==4);
        System.out.println(romanToInt("IX")==9);
        System.out.println(romanToInt("LVIII")==58);
        System.out.println(romanToInt("MCMXCIV")==1994);
        System.out.println(romanToInt("CCXVII")==217);
        System.out.println(romanToInt("DXLV")==545);
        System.out.println(romanToInt("CXLV")==145);
        System.out.println(romanToInt("XLVIII")==48);
    }

    public static int romanToInt(String s) {
        int val=0, prev=0, curr=0;
        for (int i=s.length()-1; i>=0; i--){
            curr = getInt(s.charAt(i));
            if (curr < prev){
                val -= curr;
            }
            else {
                val += curr;
            }
            prev = curr;
        }
        return val;
    }

    public static int getInt(Character ch){
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap.get(ch);
    }
}