package com.leetcode.greedy;

import java.util.*;

/**
 * Problem763Partitions
 */
public class Problem763Partitions {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("a"));
    }

    public static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public static List<Integer> partitionLabelsMySubmission(String S) {
        List<Integer> output = new ArrayList<>();
        int[] last = new int[200];

        for (int i = 0; i < S.length(); i++) {
            last[(int) S.charAt(i)] = i;
        }

        int i = 0;
        while (i < S.length()) {
            int lastIndexInPartition = last[(int) S.charAt(i)];
            while (true) {
                int lastIndex = lastIndexInPartition;
                for (int j = i; j < lastIndexInPartition; j++) {
                    lastIndex = Math.max(lastIndex, last[(int) S.charAt(j)]);
                }
                if (lastIndex == lastIndexInPartition) {
                    break;
                } else {
                    lastIndexInPartition = lastIndex;
                }
            }
            output.add(lastIndexInPartition + 1 - i);
            i = lastIndexInPartition + 1;
        }
        return output;
    }
}