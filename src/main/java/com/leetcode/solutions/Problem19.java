package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class Problem19{

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Problem19 p = new Problem19();
        ListNode l1 = p.new ListNode(1);
        l1.next = p.new ListNode(2);
        l1.next.next = p.new ListNode(3);
        l1.next.next.next = p.new ListNode(4);
        l1.next.next.next.next = p.new ListNode(5);
        printList(removeNthFromEnd(l1, 5));
    }

	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head, q=head, prev=null;
        if (n==0){
            return head;
        }
        while (p.next != null){
            if (n>1){
                p = p.next;
                n--;
                if (p.next == null && n>1){// Case when n > length of list
                    return head;
                }
                continue;
            }
            prev = q;
            q = q.next;
            p = p.next;
        }
        if (prev == null){//Case when n = length of list
            head = head.next;
            return head;
        }
        prev.next = q.next;
        q = null;
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