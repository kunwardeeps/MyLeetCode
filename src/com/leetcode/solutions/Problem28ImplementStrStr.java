package com.leetcode.solutions;

/**
 * Problem28ImplementStrStr
 */
public class Problem28ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("aaa","aaaa") == -1);
        System.out.println(strStr("mississippi","issip")==4);
        System.out.println(strStr("", "a") == -1);
        System.out.println(strStr("abccd", "b") == 1);
        System.out.println(strStr("abccd", "") == 0);
        System.out.println(strStr("abccd", "cc") == 2);
        System.out.println(strStr("abccd", "cce") == -1);
    }

    /**
     * Optimized
     * Approach: find difference of lengths, then slide all windows that fit in haystack
     * Or 
     * use KMP
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        
        if(len1<len2) {
            return -1;
        } else if (len2==0) {
            return 0;
        }
        
        int threshold = len1-len2;
        
        for (int i=0; i<=threshold; i++) {
            if (haystack.substring(i,i+len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * BruteForce
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {
        int j=0;
        if (needle == null || needle.isEmpty()){
            return 0;
        }
        for (int i=0; i<haystack.length(); i++){
            j = 0;
            while (i+j < haystack.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
                if (j == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}