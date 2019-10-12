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
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        } else {
            Node copyNode = new Node(node.val, null, null);
            map.put(node.val, copyNode);

            copyNode.next = recurse(node.next, map);
            copyNode.random = recurse(node.random, map);
            
            return copyNode;
        }
        
    }

}