package com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem11 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        stdin.nextLine();
        stdin.nextLine();
        int n = Integer.parseInt(stdin.nextLine());
        stdin.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(stdin.nextLine());
        }
        System.out.println(start(list, n));
        stdin.close();
    }

    private static int start(List<String> list, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isValid(list.get(i), list.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValid(String s1, String s2) {
        int differences = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int l = Integer.min(l1, l2);
        for (int i = 0; i < l; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differences++;
            }
        }
        if (differences == 2) {
            return true;
        }
        return false;
    }



}