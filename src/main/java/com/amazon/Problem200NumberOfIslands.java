package com.amazon;

/**
 * Problem200NumberOfIslands
 */
public class Problem200NumberOfIslands {

    public int numIslands(char[][] grid) {
        
        if (grid.length == 0) {
            return 0;
        }
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                } else {
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
        
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && !visited[i][j] && grid[i][j] == '1') {
            visited[i][j] = true;
            dfs(grid, visited, i + 1, j);
            dfs(grid, visited, i - 1, j);
            dfs(grid, visited, i, j + 1);
            dfs(grid, visited, i, j - 1);
        }
    }
}