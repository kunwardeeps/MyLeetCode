package com.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static List<Integer> topologicalSort(Map<Integer, Integer> inDegree, Map<Integer, List<Integer>> graph) {
        return null;
    }

    /**
     * 1 -> 2 -> 4
     * 1 -> 3 -> 5
     */
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(5));
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());

        Map<Integer, Integer> inDegree = new HashMap<>();
        inDegree.put(1, 0);
        inDegree.put(2, 1);
        inDegree.put(3, 1);
        inDegree.put(4, 1);
        inDegree.put(5, 1);

        System.out.println(topologicalSort(inDegree, graph));
    }

}
