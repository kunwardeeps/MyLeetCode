package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem872LeafSimilar
 */
public class Problem872LeafSimilar {

    public static void main(String[] args) {
        System.out.println(leafSimilar(TreeNode.stringToTreeNode("[18,35,22,null,103,43,101,58,null,97]"), 
            TreeNode.stringToTreeNode("[94,102,17,122,null,null,54,58,101,97]")));
        System.out.println(leafSimilar(TreeNode.stringToTreeNode("[3,5,1,6,2,9,8,null,null,7,4]"), 
            TreeNode.stringToTreeNode("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]")));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new LinkedList<>();
        List<Integer> seq2 = new LinkedList<>();
        setLeafSeq(root1, seq1);
        //System.out.println(seq1);
        setLeafSeq(root2, seq2);
        //System.out.println(seq2);
        return seq1.equals(seq2);
    }

    private static void setLeafSeq(TreeNode node, List<Integer> seq) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            seq.add(node.val);
            return;
        }
        if (node.left != null) {
            setLeafSeq(node.left, seq);
        }
        if (node.right != null) { 
            setLeafSeq(node.right, seq);
        }
    }
}