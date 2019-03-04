package com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class candidate {
    Map<String, Integer> acceptedScores = new HashMap<>();
    Map<String, Integer> acceptedTime = new HashMap<>();
}

public class Problem12 {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int t = Integer.parseInt(stdin.nextLine());
        int p = Integer.parseInt(stdin.nextLine());
        List<String> scores = new ArrayList<>();
        List<String> problems = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String[] arr = stdin.nextLine().split(" ");
            scores.add(arr[0]);
            problems.add(arr[1]);
        }
        int n = Integer.parseInt(stdin.nextLine());
        List<String> timestamps = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        List<String> submitUsers = new ArrayList<>();
        List<String> submitProblems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = stdin.nextLine().split(" ");
            timestamps.add(arr[0]);
            actions.add(arr[1]);
            ids.add(arr[2]);
            if (arr.length > 3) {
                submitUsers.add(arr[3]);
                submitProblems.add(arr[4]);
            }
            else {
                submitUsers.add("");
                submitProblems.add("");
            }
        }
        //System.out.println(start(list, n));
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