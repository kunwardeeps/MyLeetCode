package com.leetcode.solutions;

class Problem205{
    public static void main(String[] args) {
        System.out.println(isUgly(214797179) == false);
        System.out.println(isUgly(0) == false);
        System.out.println(isUgly(-1546) == false);
        System.out.println(isUgly(37) == false);
        System.out.println(isUgly(6) == true);
        System.out.println(isUgly(8) == true);
        System.out.println(isUgly(14) == false);
        System.out.println(isUgly(100000) == true);
    }

    public static boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}