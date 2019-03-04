package com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem10 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String[] arr = stdin.nextLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        List<String> list = new ArrayList<>();
        for( int i = 0; i < n; i++ )
        {
            list.add(stdin.nextLine());
        }
        System.out.println(start(list, n));
        stdin.close();
    }

    private static int start(List<String> list, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(i)){
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isMesagram(list.get(i), list.get(j))) {
                    set.add(i);
                    set.add(j);
                }
            }
        }
        return set.size();
    }

    private static boolean isMesagram(String w1, String w2) {
        Set<Character> set1 = new HashSet<>();
        for (Character c: w1.toCharArray()) {
            set1.add(c);
        }

        Set<Character> set2 = new HashSet<>();
        for (Character c: w2.toCharArray()) {
            set2.add(c);
        }
        if (set1.size() != set2.size()) {
            return false;
        }
        return set1.equals(set2); 
    }

}