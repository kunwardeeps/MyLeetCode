package com.leetcode.tree;

import java.util.List;

public class NAryNode {
    public int val;
    public List<NAryNode> children;

    public NAryNode() {}

    public NAryNode(int _val,List<NAryNode> _children) {
        val = _val;
        children = _children;
    }
};