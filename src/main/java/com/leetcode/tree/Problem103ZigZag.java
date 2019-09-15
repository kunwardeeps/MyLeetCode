package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem103ZigZag
 */
public class Problem103ZigZag {

    public static void main(String[] args) {
        
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        boolean leftToRight = true;
        LinkedList<Integer> row = null;
        

        while (!queue.isEmpty()) {
            row = new LinkedList<>();
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    row.add(node.val);
                } else {
                    row.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(row);
            leftToRight = !leftToRight;
        }

        return result;
    }
}