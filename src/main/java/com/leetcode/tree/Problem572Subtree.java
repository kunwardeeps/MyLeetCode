package com.leetcode.tree;

/**
 * Problem572Subtree
 */
public class Problem572Subtree {

    public static void main(String[] args) {
        System.out.println(isSubtree(TreeNode.stringToTreeNode("[1,1]"), TreeNode.stringToTreeNode("[1]")));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private static boolean isSameTree(TreeNode node, TreeNode t) {
        if (node == null && t == null) {
            return true;
        } else if (node == null || t == null) {
            return false;
        } else {
            return node.val == t.val && isSameTree(node.left, t.left) && isSameTree(node.right, t.right);
        }
    }

    public static boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (isSameTree(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}