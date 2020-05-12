package com.leetcode.contest;

import java.util.stream.*;
import java.util.*;

/**
 * Problem1
 */
public class Problem1 {

    public static void main(final String[] args) {
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>(n);
        buildGraph(graph, edges);
        return dfs(graph, hasApple, 0);
    }

    private int dfs(List<List<Integer>> graph, List<Boolean> hasApple, int i) {
        if (i >= graph.size() || graph.get(i).size() == 0) {
            return 0;
        }
        List<Integer> node = graph.get(i);
        int total = hasApple.get(i) ? 2 : 0;
        for (int child: node) {
            total += dfs(graph, hasApple, child);
        }
        return total;
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