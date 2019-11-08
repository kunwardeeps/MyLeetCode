package com.leetcode.dp;

import com.leetcode.arrays.ArrayHelper;

/**
 * Problem909SnakesLadders
 */
public class Problem909SnakesLadders {

    public static void main(String[] args) {
        System.out.println(snakesAndLadders(ArrayHelper.stringToInt2dArray("")));
    }

    public static int snakesAndLadders(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[] visited = new boolean[rows * columns + 1];
        return recurse(board, 1, 0, rows, columns, visited);
    }

    public static int recurse(int[][] board, int currentPos, int moves, int rows, int columns, boolean[] visited) {
        if (currentPos == rows * columns) {
            return moves;
        } else if (currentPos > rows * columns) {
            return -1;
        }
        int r = rows - 1 - (currentPos - 1) / rows;
        int c = r % 2 != 0 ? (currentPos - 1) % rows : columns - 1 - (currentPos - 1) % rows;
        int minMoves = Integer.MAX_VALUE;
        visited[currentPos] = true;

        if (board[r][c] != -1) {
            recurse(board, board[r][c], moves, rows, columns, visited);
        } else {
            for (int i = 1; i <= 6; i++) {
                if (currentPos + i > rows * columns || visited[currentPos + i]) {
                    continue;
                }
                minMoves = Math.min(minMoves, recurse(board, currentPos + i, moves + 1, rows, columns, visited));
            }
        }

        return minMoves;
    }

}