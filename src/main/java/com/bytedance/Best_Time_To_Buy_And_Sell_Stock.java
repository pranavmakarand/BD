package com.bytedance;

public class Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        //we need to 
        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);//1
            profit = Math.max(prices[i] - min, profit);
        }
        return profit;
    }
}
