package com.leetcode.solutions;

/**
 * Problem4
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.

Input: 123
Output: 321

Input: -123
Output: -321

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit 
signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your 
function returns 0 when the reversed integer overflows.
 */
public class Problem7 {

    public static void main(String[] args) {
        System.out.println(solution1(123) == 321);
        System.out.println(solution1(-123) == -321);
        System.out.println(solution1(120) == 21);
        System.out.println(solution1(2147483645)==0);

    }

	private static int solution1(int x) {
        int lastDig=0; 
        int rev=0;
        while (x!=0){
            lastDig = x%10;
            if (rev*10l > Integer.MAX_VALUE || rev*10l < Integer.MIN_VALUE){
                return 0;
            }
            rev = lastDig + 10*rev;
            x = x/10;
        }
        
		return rev;
	}

    
}