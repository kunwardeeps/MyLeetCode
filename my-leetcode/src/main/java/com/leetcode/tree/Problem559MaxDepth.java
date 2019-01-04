package com.leetcode.tree;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem559MaxDepth
 */
public class Problem559MaxDepth {

    public static void main(String[] args) {
        System.out.println();
    }

    public static int maxDepth(NAryNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int max = 0;
            for (NAryNode child: root.children) {
                max = Math.max(max, maxDepth(child));
            }
            return 1 + max;
        }
    }
}