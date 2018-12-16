package com.leetcode.solutions;

/**
 * Problem29DivideInts
 * TODO later
 */
public class Problem29DivideInts {

    public static void main(String[] args) {
        System.out.println(divide(10,3) == 3);
        System.out.println(divide(2147483647,1) == 2147483647);
        System.out.println(divide(-2147483648,-1) == 2147483647);
        System.out.println(divide(10,1) == 10);
        System.out.println(divide(10,-2) == -5);
        System.out.println(divide(10,-3) == -3);
        System.out.println(divide(0,2) == 0);
        System.out.println(divide(10,2) == 5);
    }

    public static int divide(int dividend, int divisor) {
        //handle special cases
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
     
        //get positive values
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
     
        int result = 0;
        while(pDividend>=pDivisor){
            //calculate number of left shifts
            int numShift = 0;    
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }
     
            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }
     
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }
    }

    public static int divide1(int dividend, int divisor) {
        int res = 0;

        if (dividend == 0){
            return 0;
        }

        boolean negative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            negative = true;
        }

        //handle special cases
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int q = 0;
        for (res=divisor; res<=dividend; res+=divisor){
            if (negative){
                q--;
            }
            else {
                q++;
            }
        }
        System.out.println(q);
        return q;
    }
}