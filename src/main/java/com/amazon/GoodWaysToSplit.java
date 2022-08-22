package com.amazon;

import java.util.HashSet;
import java.util.Set;

public class GoodWaysToSplit {
    public static void main(String[] args) {

    }

    public int numSplits(String s) {
        Set<Character> unique = new HashSet<>();
        int n = s.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 0; i < n; i++) {
            unique.add(s.charAt(i));
            prefix[i] = unique.size();
        }
        unique.clear();
        for (int i = n - 1; i >= 0; i--) {
            unique.add(s.charAt(i));
            suffix[i] = unique.size();
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) {
                ans++;
            }
        }
        return ans;
    }
}
