package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem448SerializeDeserialize
 */
public class Problem428SerializeDeserialize {

    public static void main(String[] args) {
        NAryNode head = new NAryNode(1, new ArrayList<>());
        head.children = Arrays.asList(new NAryNode(2, new ArrayList<>()), new NAryNode(3, new ArrayList<>()));
        System.out.println(serialize(head));
        NAryNode deserializedHead = deserialize("1,2,2,0,3,0,".split(","), 0);
        System.out.println();
    }

    public static String serialize(NAryNode nAryNode) {

        StringBuilder sb = new StringBuilder();
        sb.append(nAryNode.val);
        sb.append(",");
        sb.append(nAryNode.children.size());
        sb.append(",");

        for (NAryNode child: nAryNode.children) {
            sb.append(serialize(child));
        }
        return sb.toString();
    }

    public static NAryNode deserialize(String[] str, int idx) {
        if (idx > str.length - 1) {
            return null;
        }
        NAryNode head = new NAryNode(Integer.parseInt(str[idx]), new ArrayList<>());
        int children = Integer.parseInt(str[idx + 1]);
        for (int i = 0; i < children; i++) {
            idx = idx + 2;
            head.children.add(deserialize(str, idx));
        }
        return head;
    }
}