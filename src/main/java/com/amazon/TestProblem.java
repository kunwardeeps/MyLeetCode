package com.amazon;

import java.util.*;
import java.util.stream.Collectors;
/**
 * SubstringProblem
 */
public class TestProblem {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    private static int time = 0;

    private static List<Integer> getCriticalNodes(int numRouters, int numLinks, ArrayList<ArrayList<Integer>> links) {
        Map<Integer, Set<Integer>> adjRoutersMap = new HashMap<>();
        for(int i = 0; i < numRouters; i++) {
            adjRoutersMap.put(i, new HashSet<>());
        }
        links.stream().forEach(link -> {
            adjRoutersMap.get(link.get(0)).add(link.get(1));
            adjRoutersMap.get(link.get(1)).add(link.get(0));
        });
        Set<Integer> resultSet = new HashSet<>();
        int[] lowestTimeArr = new int[numRouters];
        int[] discoveryTimeArr = new int[numRouters];
        int[] parentNodeArr = new int[numRouters];

        Arrays.fill(discoveryTimeArr, -1);
        Arrays.fill(parentNodeArr, -1);

        for(int i = 0; i < numRouters; i++) {
            if(discoveryTimeArr[i] == -1) {
                helper(adjRoutersMap, lowestTimeArr, discoveryTimeArr, parentNodeArr, i, resultSet);
            }
        }
        return resultSet.stream().collect(Collectors.toList());
    }
    
    
    
    private static void helper(Map<Integer, Set<Integer>> adjRoutersMap, int[] lowestTimeArr, int[] discoveryTimeArr, int[] parentNodeArr, int currentNode, Set<Integer> resultSet) {
        int childNodes = 0;

        time++;
        discoveryTimeArr[currentNode] = time;
        lowestTimeArr[currentNode] = time;

        Set<Integer> neighbors = adjRoutersMap.get(currentNode);

        for (Integer neighbor: neighbors) {
            if (discoveryTimeArr[neighbor] == -1) {
                childNodes++;
                parentNodeArr[neighbor] = currentNode;
                helper(adjRoutersMap, lowestTimeArr, discoveryTimeArr, parentNodeArr, neighbor, resultSet);

                lowestTimeArr[currentNode] = Math.min(lowestTimeArr[currentNode], lowestTimeArr[neighbor]);
                
                if ((parentNodeArr[currentNode] == -1 && childNodes > 1) || (parentNodeArr[currentNode] != -1 && lowestTimeArr[neighbor] >= discoveryTimeArr[currentNode])) {
                    resultSet.add(currentNode);
                }
            }
            else if (neighbor != parentNodeArr[currentNode]) {
                lowestTimeArr[currentNode] = Math.min(lowestTimeArr[currentNode], discoveryTimeArr[neighbor]);
            }
        }
    }
}