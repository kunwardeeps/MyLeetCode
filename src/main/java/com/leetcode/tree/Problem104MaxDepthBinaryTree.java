package com.leetcode.tree;

/**
 * Problem104MaxDepthBinaryTree
 */
public class Problem104MaxDepthBinaryTree {

    public static void main(String[] args) {
        System.out.println(maxDepth(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]")));
        System.out.println(maxDepth(TreeNode.stringToTreeNode("[3]")));
    }

    public static int maxDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        else {
            return 0;
        }
    }
}