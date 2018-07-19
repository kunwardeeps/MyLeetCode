package com.leetcode.solutions;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Learnings:
1. Use test cases
2. Address is assigned only when object is created and not when ref variable is initialized as null.
So, this won't work
header = curr
curr = curr.next (null)
curr = new Object()
Now, header.next and curr.next hold references to different objects (header.next is still null!)
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Problem2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currentNode = null;
        ListNode header = null;
        ListNode prev = null;
        int d1;
        int d2;
        int carry=0;
        int sum=0;

        while (l1 != null || l2 != null || carry > 0){
            d1=l1!=null? l1.val: 0;
            d2=l2!=null? l2.val: 0;
            sum = d1+d2+carry;
            currentNode = new ListNode(sum%10); //Remainder
            if (header == null){
                header = currentNode;
            }
            else {
                prev.next = currentNode;
            }
            carry = sum/10;
            l1 = l1!=null? l1.next: null;
            l2 = l2!=null? l2.next: null;
            prev = currentNode;
        }
        return header;
        
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        // l1.next = new ListNode(8);
        // l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null){
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}