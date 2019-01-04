package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem617MergeBinaryTrees {
    public static void main(String[] args) {
        System.out.println(TreeNode.treeNodeToString(mergeTrees(TreeNode.stringToTreeNode("[1,3,2,5]"), 
            TreeNode.stringToTreeNode("[2,1,3,null,4,null,7]"))) == "");
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        int h = Math.max(getHeight(t1), getHeight(t2));
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode n = null;

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(t1);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(t2);

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode t = mergeNode(t1, t2);
        q.add(t);
        List<Integer> result = new ArrayList<>();


        while (!q.isEmpty()){
            n1 = q1.poll();
            n2 = q2.poll();
            n = q.poll();

            if (n != null){
                n.left = mergeNode(n1.left, n2.left);
                n.right = mergeNode(n1.right, n2.right);

                q1.add(n1.left);
                q1.add(n1.right);
                
                q2.add(n2.left);
                q2.add(n2.right);

                q.add(n.left);
                q.add(n.right);
                
            }
        }

        return t;
    }

    private static TreeNode mergeNode(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        else if (n1 == null) {
            return new TreeNode(n2.val);
        }
        else if (n2 == null) {
            return new TreeNode(n1.val);
        }
        else {
            return new TreeNode(n1.val + n2.val);
        }
    }

    public static int getHeight(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(t.left), getHeight(t.right));
    }

    
}