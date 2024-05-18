package com.algos;

public class LinkedListReverse {

    public static ListNode reverse(ListNode head) {
        return null;
    }

    public static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        print(reverse(n1));
    }
}

class ListNode {
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}
