package com.leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem1030GreaterNodeLinkedList
 */
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class Problem1030GreaterNodeLinkedList {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        int[] result = new int[list.size()];
        if (list.size() == 1) {
            return new int[] {0};
        }
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            for (j = i + 1; j < list.size() && list.get(i) >= list.get(j); j++);
            
            if (j == list.size()) {
                result[i] = 0;
            }
            else {
                while (i < j) {
                    result[i] = list.get(j);
                    i++;
                }
            }
        }
        return result;
    }
}