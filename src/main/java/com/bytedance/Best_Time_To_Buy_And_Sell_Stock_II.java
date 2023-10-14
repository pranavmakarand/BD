package com.bytedance;

public class Best_Time_To_Buy_And_Sell_Stock_II {
	
    public int maxProfit(int[] prices) {
        int[][] visited = new int [prices.length][2];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < 2; j++) {
                visited[i][j] = -1; 
            }
        }
        return dp(0, 1, prices, visited);
    }

    private int dp(int n, int buy, int[] prices, int [][] visited) {

        if (n == prices.length) {
            return 0;
        }

        if (visited[n][buy] != -1) {
            return visited[n][buy];
        }

        if (buy == 1) {
            int toBuy = -prices[n] + dp(n + 1, 0, prices, visited);
            int toNotBuy = 0 + dp(n + 1, 1, prices, visited);
            visited[n][buy] = Math.max(toBuy, toNotBuy);
        } else {
            int toSell = prices[n] + dp(n + 1, 1, prices, visited);
            int toNotSell = dp(n + 1, 0, prices, visited);
            visited[n][buy] = Math.max(toSell, toNotSell);
        }

        return visited[n][buy];
    }
}
