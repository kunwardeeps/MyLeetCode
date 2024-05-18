package com.algos;

public class Trie {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
    private TrieNode root = new TrieNode();

    public void addWord(String word) {
    }

    public boolean search(String word) {
        return false;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.addWord("word");
        t.addWord("hello");
        System.out.println(t.search("word") == true);
        System.out.println(t.search("hello") == true);
        System.out.println(t.search("abc") == false);
    }
}
