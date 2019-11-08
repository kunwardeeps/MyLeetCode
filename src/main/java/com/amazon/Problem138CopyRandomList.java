package com.amazon;

import java.util.HashMap;
import java.util.Map;

class ALNode {
    public int val;
    public ALNode next;
    public ALNode random;

    public ALNode() {}

    public ALNode(int _val,ALNode _next,ALNode _random) {
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

    public static ALNode copyRandomList(ALNode head) {
        Map<Integer, ALNode> map = new HashMap<>();
        if (head == null) {
            return null;
        }
        return recurse(head, map);
    }

    private static ALNode recurse(ALNode node, Map<Integer, ALNode> map) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        } else {
            ALNode copyNode = new ALNode(node.val, null, null);
            map.put(node.val, copyNode);

            copyNode.next = recurse(node.next, map);
            copyNode.random = recurse(node.random, map);
            
            return copyNode;
        }
        
    }

}