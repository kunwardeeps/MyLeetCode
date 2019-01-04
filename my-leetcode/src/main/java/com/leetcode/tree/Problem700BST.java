package com.leetcode.tree;

/**
 * Problem700BST
 */
public class Problem700BST {

    public static void main(String[] args) {
        System.out.println(TreeNode.treeNodeToString(searchBST(TreeNode.stringToTreeNode("[4,2,7,1,3]"), 8)));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        else if (root.val > val) {
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }
}