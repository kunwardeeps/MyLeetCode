package com.leetcode.solutions;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Problem687{

    static int max = 1;
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);
        // t1.left = t2;
        // t1.right = t3;
        // t2.left = t4;
        // t2.right = t5;
        // t3.right = t6;
        System.out.println(longestUnivaluePath(t1));
    }

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, 1);
        return max - 1;
    }

    public static void dfs(TreeNode node, int count) {
        max = Math.max(max, count);
        if (node.left != null) {
            if (node.left.val == node.val){
                dfs(node.left, count+1);
            }
            else {
                dfs(node.left, 1);
            }
        }
        if (node.right != null) {
            if (node.right.val == node.val){
                dfs(node.right, count+1);
            }
            else {
                dfs(node.right, 1);
            }
        }
    }
}