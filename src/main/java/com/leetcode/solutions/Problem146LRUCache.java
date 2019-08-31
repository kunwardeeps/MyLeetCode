package com.leetcode.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Problem146LRUCache
 */
public class Problem146LRUCache {

    public static void main(String[] args) {
        
    }
}

class LruNode {
    public int key;
    public int value;
    public LruNode next;
    public LruNode prev;

    public LruNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private LruNode head, tail;
    private Map<Integer, LruNode> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.head = new LruNode(0,0);
        this.tail = new LruNode(0,0);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public void add(LruNode node) {
        LruNode oldHead = head.next;

        head.next = node;
        node.prev = head;
        node.next = oldHead;

        oldHead.prev = node;
    }

    public LruNode evict() {
        LruNode lastLruNode = tail.prev;
        lastLruNode.prev.next = tail;
        tail.prev = lastLruNode.prev;
        return lastLruNode;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //todo
    }
}