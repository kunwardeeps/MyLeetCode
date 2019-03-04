package com.leetcode.contest;

public class Problem4 {

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(1, 5));
        System.out.println(strWithout3a3b(2, 7));
        System.out.println(strWithout3a3b(2, 6));
        System.out.println(strWithout3a3b(1, 4));
        System.out.println(strWithout3a3b(1, 3));
        System.out.println(strWithout3a3b(0, 3));
        System.out.println(strWithout3a3b(0, 0));
        System.out.println(strWithout3a3b(2, 0));
        System.out.println(strWithout3a3b(0, 2));
        System.out.println(strWithout3a3b(1, 2));
        System.out.println(strWithout3a3b(4, 1));
    }

    public static String strWithout3a3b(int A, int B) {
        int aCount = 0;
        int bCount = 0;
        int l = A+B;
        int min = 0, max = 0;

        if (A > B) {
            max = A;
            min = B;
        }
        else {
            max = B;
            min = A;
        }
        if (max > (min * 2 + 2)) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        

        while (result.length() < l) {
            while (result.length() < l && (A >= B || bCount == 2) && A > 0 && aCount < 2) {
                result.append('a');
                aCount++;
                bCount = 0;
                A--;
            }
            while (result.length() < l && (A <= B || aCount == 2) && B > 0 && bCount < 2) {
                result.append('b');
                bCount++;
                aCount = 0;
                B--;
            }
        }
        return result.toString();
    }

    


}