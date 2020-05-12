package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Problem54SpiralMatrix {
    public static void main(String[] args) {
        
    }

    public List<Integer> spiralOrderShitty(int[][] matrix) {
        int l = Math.min(matrix.length, matrix[0].length);
        List<Integer> result = new ArrayList<>();
        int c = 0;
        int i = 0, j = 0;
        for (i = 0; i <= l / 2; i++) {
            c = i;
            for (j = i; j < matrix[0].length - i; j++) {
                result.add(matrix[c][j]);
            }

            c = j - 1;
            for (j = i + 1; j < matrix.length - i; j++) {
                result.add(matrix[j][c]);
            }
            
            c = j - 1;
            for (j = matrix[0].length - i - 2; j >= i; j--) {
                result.add(matrix[c][j]);
            }

            c = i;
            for (j = matrix.length - i - 2; j > i; j--) {
                result.add(matrix[j][c]);
            }

        }
        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
}