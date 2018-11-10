package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Problem24SwapNodes{

    public static void main(String[] args) {
        printList(swapPairs(createList(new int[] {})));
        printList(swapPairs(createList(new int[] {1})));
        printList(swapPairs(createList(new int[] {1, 2, 3})));
        printList(swapPairs(createList(new int[] {1, 2, 3, 4})));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode newHead = null;
        ListNode prev = null;
        while (current != null){
            ListNode next = current.next;
            if (newHead == null){
                newHead = next;
                if (next == null){
                    return current;//Single node case
                }
            }
            if (next == null){
                break;
            }
            if (prev != null){
                prev.next = next;
            }
            current.next = next.next;
            next.next = current;
            prev = current;
            current = current.next;
        }
        return newHead;
    }

    private static ListNode createList(int[] arr){
        if (arr.length == 0){
            return null;
        }
        ListNode head = null;
        ListNode node = null;
        for (int i: arr){
            if (head == null){
                head = new ListNode(i);
                node = head;
            }
            else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return head;
    }

    private static void printList(ListNode node) {
        List<Integer> result = new ArrayList<>();
        while(node!=null){
            result.add(node.val);
            node = node.next;
        }
        System.out.println(result);
	}

}