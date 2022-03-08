package com.algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstras {
    
    public static void dijkstra(Map<Integer, Map<Integer, Integer>> graph, int N, int K) {
        //Pair is a pojo with label and current distance
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2) -> p1.dist - p2.dist);
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new Pair(K, 0));//Initialize first node dist with 0
        
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll(); //get the unvisited node with min distance
            
            if (visited.contains(cur.label)) continue;
            visited.add(cur.label);
    
            if (!graph.containsKey(cur.label)) continue;
            
            for (int neighbor : graph.get(cur.label).keySet()) {
                minHeap.offer(new Pair(neighbor, cur.dist + graph.get(cur.label).get(neighbor)));
            }
        }
    }

    /** https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     */
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.computeIfAbsent(0, e -> new HashMap<>()).put(1, 4);
        graph.computeIfAbsent(0, e -> new HashMap<>()).put(7, 8);
        graph.computeIfAbsent(1, e -> new HashMap<>()).put(0, 4);
        graph.computeIfAbsent(1, e -> new HashMap<>()).put(7, 11);
        graph.computeIfAbsent(1, e -> new HashMap<>()).put(2, 8);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(0, 8);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(1, 11);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(8, 7);
        graph.computeIfAbsent(7, e -> new HashMap<>()).put(6, 1);
        graph.computeIfAbsent(2, e -> new HashMap<>()).put(1, 8);
        graph.computeIfAbsent(2, e -> new HashMap<>()).put(8, 2);
        graph.computeIfAbsent(8, e -> new HashMap<>()).put(7, 7);
        graph.computeIfAbsent(8, e -> new HashMap<>()).put(2, 2);
        graph.computeIfAbsent(8, e -> new HashMap<>()).put(6, 6);
        graph.computeIfAbsent(6, e -> new HashMap<>()).put(8, 6);
        graph.computeIfAbsent(6, e -> new HashMap<>()).put(7, 1);
        dijkstra(graph, graph.keySet().size(), 0);
    }
}

class Pair {
    int label;
    int dist;
    public Pair(int k, int i) {
        this.label = k;
        this.dist = i;
    }
}
