package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem21{

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
        Problem21 p = new Problem21();
        ListNode l1 = p.new ListNode(1);
        l1.next = p.new ListNode(2);
        l1.next.next = p.new ListNode(4);

        ListNode l2 = p.new ListNode(1);
        l2.next = p.new ListNode(3);
        l2.next.next = p.new ListNode(4);
        printList(p.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode head = null;
        ListNode current = null;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (head == null) {
                    head = new ListNode(head1.val);
                    current = head;
                } else {
                    current.next = new ListNode(head1.val);
                    current = current.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = new ListNode(head2.val);
                    current = head;
                } else {
                    current.next = new ListNode(head2.val);
                    current = current.next;
                }
                head2 = head2.next;
            }
        }
        
        while (head1 != null) {
            if (head == null) {
                head = new ListNode(head1.val);
                current = head;
            } else {
                current.next = new ListNode(head1.val);
                current = current.next;
            }
            head1 = head1.next;
        }
        
        while (head2 != null) {
            if (head == null) {
                head = new ListNode(head2.val);
                current = head;
            } else {
                current.next = new ListNode(head2.val);
                current = current.next;
            }
            head2 = head2.next;
        }
        
        return head;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }

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