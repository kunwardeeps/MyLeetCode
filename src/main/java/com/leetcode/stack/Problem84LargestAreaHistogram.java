package com.leetcode.stack;

import java.util.Stack;

public class Problem84LargestAreaHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {6, 7, 5, 2, 4, 5, 9, 3}));
    }

    public static int largestRectangleArea(int[] h) {
        int n = h.length, max = 0;
    
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < h.length; i++) {
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                int height = h[s.pop()];
                int width = (i - (s.isEmpty() ? 0 : s.peek() + 1));
                max = Math.max(max, height * width);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
        }

        return max;
    }
}