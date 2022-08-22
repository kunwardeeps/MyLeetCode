package com.amazon;

public class GetHeaviestPackage {
    public static void main(String[] args) {
        System.out.println(getHeaviestPackage(new int[] {2, 9, 10, 3, 7}));
    }

    public static int getHeaviestPackage(int[] input) {
        int max = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] < max) {
                max += input[i]; // merge
            } else {
                max = input[i]; // too big to merge - this is the new max
            }
        }
        return max;
    }
}
