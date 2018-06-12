package com.leetcode.solutions;

class Problem9{
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

	private static boolean isPalindrome(int i) {
        if (i<0) return false;
		return i == Problem7.solution1(i);
	}
}