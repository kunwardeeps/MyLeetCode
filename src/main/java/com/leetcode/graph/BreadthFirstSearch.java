package com.leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BreadthFirstSearch
 */
public class BreadthFirstSearch {

    private List<Integer> adj[];
    private int V;

    public BreadthFirstSearch(int v) { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 

    public void BFSTraversal(int s) { 
        boolean visited[] = new boolean[5]; 
  
        Queue<Integer> queue = new LinkedList<Integer>(); 
        visited[s] = true; 
        queue.add(s); 
  
        while (queue.size() != 0) { 
            s = queue.poll(); 
            System.out.print(s+" "); 

            for (Integer n: adj[s]) { 
                if (!visited[n]) { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    }
    
}