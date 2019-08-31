package com.leetcode.linkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * Problem445AddNumbers
 */
public class Problem445AddNumbers {

    
    public static void main(String[] args) {
        System.out.println(listNodeToString(addTwoNumbers(stringToListNode("[7,2,4,3]"), stringToListNode("[5,6,4]"))));
        System.out.println(listNodeToString(addTwoNumbers(stringToListNode("[5]"), stringToListNode("[5]"))));
        System.out.println(listNodeToString(addTwoNumbers(stringToListNode("[]"), stringToListNode("[]"))));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverseList(l1);
        ListNode node2 = reverseList(l2);

        ListNode addedListReversed = add(node1, node2);

        return reverseList(addedListReversed);
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode head = null;
        ListNode prev = null;

        while (l1 != null || l2 != null) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            ListNode current = new ListNode(sum % 10);
            if (head == null) {
                head = current;
            }
            carry = sum / 10;
            if (prev != null) {
                prev.next = current;
            }
            prev = current;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }

    public static ListNode reverseList(ListNode listNode) {
        ListNode current = listNode;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }


}