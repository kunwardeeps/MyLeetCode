package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node next;
    Node(int x) { val = x; }
}

class Problem24SwapNodes{

    public static void main(String[] args) {
        printList(swapPairs(createList(new int[] {})));
        printList(swapPairs(createList(new int[] {1})));
        printList(swapPairs(createList(new int[] {1, 2, 3})));
        printList(swapPairs(createList(new int[] {1, 2, 3, 4})));
    }

    public static Node swapPairs(Node head) {
        Node current = head;
        Node newHead = null;
        Node prev = null;
        while (current != null){
            Node next = current.next;
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

    private static Node createList(int[] arr){
        if (arr.length == 0){
            return null;
        }
        Node head = null;
        Node node = null;
        for (int i: arr){
            if (head == null){
                head = new Node(i);
                node = head;
            }
            else {
                node.next = new Node(i);
                node = node.next;
            }
        }
        return head;
    }

    private static void printList(Node node) {
        List<Integer> result = new ArrayList<>();
        while(node!=null){
            result.add(node.val);
            node = node.next;
        }
        System.out.println(result);
	}

}