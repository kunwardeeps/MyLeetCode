package com.leetcode.dp;

/**
 * Problem121TradeStock
 */
public class Problem122TradeStock2 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}) == 7);
        System.out.println(maxProfit(new int[] {2,4,1}) == 2);
        System.out.println(maxProfit(new int[] {1,2,3,4}) == 3);
        System.out.println(maxProfit(new int[] {1,1,1,1}) == 0);
        System.out.println(maxProfit(new int[] {7,6,4,3,1}) == 0);
        System.out.println(maxProfit(new int[] {}) == 0);
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int totProfit = 0;
        int profit = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (prices.length -1 - startIdx > 1){
            profit = 0;
            for (int i = startIdx; i<prices.length; i++){
                min = Math.min(min, prices[i]);
                if (prices[i] > min && prices[i] - min > profit){
                    profit = prices[i] - min;
                    endIdx = i;
                }
            }
            if (profit == 0){
                return 0;
            }
            totProfit += profit;
            startIdx = endIdx + 1;
        }
        
        return totProfit;
    }
}