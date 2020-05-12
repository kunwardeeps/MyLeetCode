package com.amazon;

import java.util.Arrays;

/**
 * Problem937RearrangeLogs
 */
public class Problem937RearrangeLogs {

    public static void main(String[] args) {
        
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] s1arr = s1.split(" ");
            String[] s2arr = s1.split(" ");
            if (Character.isDigit(s1arr[1].charAt(0))) {
                return 1;
            }
            return s1.compareTo(s2);
        });
        return logs;
    }
}