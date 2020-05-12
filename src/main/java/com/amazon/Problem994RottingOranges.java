package com.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem994RottingOranges
 */
public class Problem994RottingOranges {

    public static void main(final String[] args) {
        
    }

    class Position{
        int x; 
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int totalFresh = 0;
        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Position(i, j));
                }
                else if (grid[i][j] == 1) {
                    totalFresh++;
                }
            }
        }

        if (totalFresh == 0) {
            return 0; 
        }

        int minutes = -1;
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Position current = queue.poll();
                for (int[] dir : directions) {
                    int x = current.x + dir[0];
                    int y = current.y + dir[1];

                    if (x >= grid.length || y >= grid[0].length || y < 0 || x < 0) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        queue.offer(new Position(x, y));
                        grid[x][y] = 2; 
                        totalFresh--;
                    }
                }
            }
        }
        
        if (totalFresh > 0) {
            return -1;
        } else {
            return minutes;
        }
    }
}