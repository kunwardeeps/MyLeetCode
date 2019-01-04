package com.leetcode.contest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem965UnivaluedTree
 */
public class Problem965UnivaluedTree {

    public static void main(String[] args) {
        System.out.println(isUnivalTree(stringToTreeNode("[0]")));
        System.out.println(isUnivalTree(stringToTreeNode("[1,1,0,1,1,null,1]")));
        System.out.println(isUnivalTree(stringToTreeNode("[1,1,1,1,1,null,1]")));
        System.out.println(isUnivalTree(stringToTreeNode("[]")));
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int rootVal = root.val;
        return recurse(root, rootVal);
    }

    public static boolean recurse(TreeNode root, int rootVal) {
        if (root.val == rootVal) {
            boolean left = true;
            boolean right = true;
            if (root.left != null) {
                left = recurse(root.left, rootVal);
            }
            if (root.right != null) {
                right = recurse(root.right, rootVal);
            }
            return left && right;
        }
        else {
            return false;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}