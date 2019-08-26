package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

/**
 * Problem138CopyRandomList
 */
public class Problem138CopyRandomList {

    public static void main(String[] args) {
        System.out.println();
    }

    public static Node copyRandomList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        return recurse(head, map);
    }

    private static Node recurse(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        } else {
            Node newNode = new Node(node.val, null, null);
            map.put(newNode.val, newNode);
            if (node.next != null) {
                newNode.next = recurse(node.next, map);
            }
            if (node.random != null) {
                newNode.random = recurse(node.random, map);
            }
            return newNode;
        }
    }

}