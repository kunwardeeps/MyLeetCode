package com.algos;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KNN {

    public static void main(String[] args) {
        System.out.println(Arrays.deepEquals(kClosest(new int[][] {{ 1, 3 }, { -2, 2 }}, 1), 
        new int[][] {{-2, 2}}));
        System.out.println(Arrays.deepEquals(kClosest(new int[][] {{ 3, 3 }, { 5, -5 }, { -2, 4}}, 2), 
        new int[][] {{ 3, 3 }, { -2, 4}}));
    }

    public static int[][] kClosest(int[][] points, int K) {
        return null;
    }
}
