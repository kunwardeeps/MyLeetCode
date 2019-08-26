package com.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

/**
 * Problem133CloneGraph
 */
public class Problem133CloneGraph {

    public static void main(String[] args) {
        System.out.println();
    }

    public static Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return recurse(node, map);
    }

    private static Node recurse(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);
        for (Node neighbor: node.neighbors) {
            newNode.neighbors.add(recurse(neighbor, map));
        }
        return newNode;
    }


}