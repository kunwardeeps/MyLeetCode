package com.leetcode.contest;

import java.util.stream.*;
import java.util.*;

/**
 * Problem1
 */
public class Problem1 {

    public static void main(final String[] args) {
    }

    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(0, new ArrayList<>());
        }
        Set<String> dirs = new HashSet<>();
        buildGraph(connections, graph, dirs);
        return connections.length - dfs(graph, dirs, visited, 0, -1);
    }

    private int dfs(List<List<Integer>> graph, Set<String> dirs, boolean[] visited, int i, int prev) {
        int count = 0;
        if (visited[i]) {
            return count;
        }
        visited[i] = true;
        if (prev != -1 && dirs.contains(prev + "#" + i)) {
            count++;
        }
        for (int next: graph.get(i)) {
            count += dfs(graph, dirs, visited, next, i);
        }
        return count;
    }

    private void buildGraph(int[][] connections, List<List<Integer>> graph, Set<String> dirs) {
        for (int i = 0; i < connections.length; i++) {
            dirs.add(connections[i][0] + "#" + connections[i][1]);
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
    }

    public int numPoints(int[][] points, int r) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] point: points) {
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
            minX = Math.max(minX, point[0]);
            minY = Math.max(minY, point[1]);
        }

        int maxPoints = 0;

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= minY; j++) {
                maxPoints = Math.max(maxPoints, getPointsInside(points, r, i, j));
            }
        }
        return maxPoints;
    }

    private int getPointsInside(int[][] points, int r, int i, int j) {
        int total = 0;
        for (int[] point: points) {
            if (pointInside(point, r, i, j)) {
                total++;
            }
        }
        return total;
    }

    private boolean pointInside(int[] point, int r, int i, int j) {
        return (i - point[0]) * (i - point[0]) + (j - point[1]) * (j - point[1]) <= r*r;
    }

    private void buildGraph(List<List<Integer>> graph, int[][] edges) {
        for (int[] edge: edges) {
            graph.add(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }
    }

    public int maxScore(int[] cardPoints, int k) {
        return recurse(cardPoints, k, 0, cardPoints.length - 1);
    }
    
    private int recurse(int[] cardPoints, int k, int l, int r) {
        if (k == 0 || l > r) {
            return 0;
        }
        List<Integer> s = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, (a,b) -> b - a);
        //s.addAll(cardPoints);

        return Math.max(cardPoints[l] + recurse(cardPoints, k - 1, l + 1, r), 
            cardPoints[r] + recurse(cardPoints, k - 1, l, r - 1));
    }

    boolean isBalanced(String s) {
        // Write your code here
        Stack<Character> st = new Stack<>();
        
        for (char c: s.toCharArray()) {
          switch(c) {
          case '{': st.push('}'); break;
          case '[': st.push(']'); break;
          case '(': st.push(')'); break;
          default:
          if (st.isEmpty() || c != st.peek()) {
            return false;
          } else {
            st.pop();
          }
        }
    }
        return true;
      }

    public int getChars(String s, char t) {
        int total = 0;
        for (char c: s.toCharArray()) {
            if (c == t) {
                total++;
            }
        }
        return total;
    }

    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new LinkedList<>();
        int[] result = new int[queries.length];
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int idx = list.indexOf(queries[i]);
            int n = list.remove(idx);
            list.add(0, n);
            result[i] = idx;
        }
        return result;
    }

    public int numOfWays(int n) {
        int[][] grid = new int[n][3];
        return fillColor(grid, 1, 0) + fillColor(grid, 2, 0) + fillColor(grid, 3, 0);
    }
    
    private int fillColor(int[][] grid, int color, int i) {
        if (i > grid.length * grid[0].length) {
            return 0;
        }
        int r = i / 3;
        int c = i % 3;
        int adjUp = 0;
        int adjLeft = 0;
        if (r > 0) {
            adjUp = grid[r - 1][c];
        }
        if (c > 0) {
            adjLeft = grid[r][c - 1];
        }
        if (adjLeft == color || adjUp == color) {
            return 0;
        }
        grid[r][c] = color;
        int ways = fillColor(grid, 1, i + 1) + fillColor(grid, 2, i + 1) + fillColor(grid, 3, i + 1);
        grid[r][c] = 0;
        return ways;
    }

    public String entityParser(String text) {
        String[] entities = {"&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;"};
        String[] replacements = {"\"", "'", "&", ">", "<", "/"};
        for (int i = 0; i < 6; i++) {
            text = text.replaceAll(entities[i], replacements[i]);
        }
        return text;
    }

    private boolean exitLoop(int[] arr) {
        int i = 0;
        if (arr[0] == 0) {
            i++;
        }
        if (arr[1] == 0) {
            i++;
        }
        if (arr[2] == 0) {
            i++;
        }
        return i > 1;
    }

}