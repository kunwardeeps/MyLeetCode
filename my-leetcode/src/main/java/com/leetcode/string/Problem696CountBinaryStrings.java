package com.leetcode.string;

/**
 * Problem696CountBinaryStrings
 */
public class Problem696CountBinaryStrings {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011") == 6);
        System.out.println(countBinarySubstrings("10101") == 4);
        System.out.println(countBinarySubstrings("10") == 1);
        System.out.println(countBinarySubstrings("00") == 0);
        System.out.println(countBinarySubstrings("11") == 0);

    }

    public static int countBinarySubstrings(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int count = 0;
        int ones = 0;
        int zeroes = 0;
        int changes = 0;
        if (s.charAt(0) == '0') {
            zeroes++;
        }
        else {
            ones++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                changes++;
                if (changes > 0 && changes % 2 == 0) {
                    changes = 0;
                    count += Math.min(ones, zeroes);
                    ones = 0;
                    zeroes = 0;
                }
            }
            if (s.charAt(i) == '0') {
                zeroes++;
            }
            else {
                ones++;
            }
        }
        if (changes == 1) {
            count += Math.min(ones, zeroes);
        }
        return count;
    }

    public static int countBinarySubstringsSlow(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int count = 0;
        int ones = 0;
        int zeroes = 0;
        int changes = 0;

        for (int i = 0; i < s.length(); i++) {
            zeroes = 0;
            ones = 0;
            changes = 0;
            if (s.charAt(i) == '0') {
                zeroes++;
            }
            else {
                ones++;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j-1)) {
                    changes++;
                    if (changes > 1) {
                        break;
                    }
                }
                if (s.charAt(j) == '0') {
                    zeroes++;
                }
                else {
                    ones++;
                }
                if (zeroes == ones) {
                    //System.out.println(s.substring(i, j+1));
                    count++;
                }
            }
        }
        return count;
    }
}