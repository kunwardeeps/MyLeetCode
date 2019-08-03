package com.leetcode.dp;

/**
 * Problem121TradeStock
 */
public class Problem121TradeStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {2,4,1}) == 2);
        System.out.println(maxProfit(new int[] {1,2,3,4}) == 3);
        System.out.println(maxProfit(new int[] {1,1,1,1}) == 0);
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}) == 5);
        System.out.println(maxProfit(new int[] {7,6,4,3,1}) == 0);
        System.out.println(maxProfit(new int[] {}) == 0);
    }

    public static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndx = Integer.MIN_VALUE;;
        for (int i=0; i<prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
                minIndx = i;
            }
            if (prices[i] > min && prices[i] > max 
                && i > minIndx){
                max = prices[i];
            }
        }
        if (max == Integer.MIN_VALUE){
            return 0;
        }
        else {
            return max - min;
        }
    }

    /**
     * Elegant approach
     */
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}