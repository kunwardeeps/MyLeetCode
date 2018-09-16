package com.leetcode.solutions;

public class Test{
    public static void main(String[] args) {
        System.out.println(solution(new int []{1,2,3,4,5}));
    }

	public static int solution(int[] A) { 
        int len = A.length;
        int total = 0;

        for (int i: A) 
            total += i;
      
        boolean dp[][] = new boolean[len+1][total+1]; 
      
        //Initialize 
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= total; i++) {
            dp[0][i] = false; 
        }

        for (int i = 1; i <= len; i++) { 
            for (int j = 1; j <= total; j++) { 

                dp[i][j] = dp[i-1][j];
      
                if (A[i-1] <= j) {
                    dp[i][j] = dp[i][j] | dp[i-1][j-A[i-1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int i = total/2; i >= 0; i--) {
            if (dp[len][i] == true) {
                return diff = total-2*i;
            }
        }
        return diff;
    }
}