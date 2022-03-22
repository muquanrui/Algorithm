package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 22/03/2022 21:38
 */
public class LeetCode0188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k];
        for (int j = 0; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], j == 0 ? -prices[i] : dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k - 1];
    }
}
