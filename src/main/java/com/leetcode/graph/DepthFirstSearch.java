package com.leetcode.graph;

import java.util.List;

/**
 * DepthFirstSearch
 */
public class DepthFirstSearch {

    private List<Integer> adj[];
    private int V;

    public void dfs(int v, boolean[] visited) { 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        for (Integer n: adj[v]) { 
            if (!visited[n]) {
                dfs(n, visited); 
            }
        } 
    } 

    void topologicalSort(int v, boolean visited[]) { 
        visited[v] = true; 
  
        for (Integer n: adj[v]) { 
            if (!visited[n]) {
                dfs(n, visited); 
            }
        } 
        System.out.println(v);
    } 
}