package com.leetcode.solutions;

public class Test{
    public static void main(String[] args) {
        recurse(0, 0);
    }

	private static void recurse(int i, int j) {
        if (i+j == 10){
            System.out.println(i +","+ j);
        }
        else {
            recurse(i+1, j);
            recurse(i, j+1);
        }
	}
}