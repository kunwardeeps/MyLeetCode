package com.leetcode.contest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem5017
 */
public class Problem5017 {

    public static void main(String[] args) {
        sumRootToLeaf();
    }

    public static void sumRootToLeaf() {
        BigInteger bigInt1 = new BigInteger("11", 2);
        BigInteger bigInt2 = new BigInteger("11", 2);
        System.out.println(bigInt1.add(bigInt2).intValue());
        // recurse(root, "", bigInt);
        // BigInteger mod = new BigInteger("1000000007");
        // return bigInt.mod(mod).intValue();
    }
    
    public static void recurse(TreeNode root, String path, BigInteger sum) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            recurse(root.left, path + root.val, sum);
        }
        if (root.right != null) {
            recurse(root.right, path + root.val, sum);
        }
        if (root.left == null && root.right == null) {
            sum.add(new BigInteger(path + root.val, 2));
        }
    }
}