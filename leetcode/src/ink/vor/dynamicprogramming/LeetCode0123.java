package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 22/03/2022 21:06
 */
public class LeetCode0123 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = -prices[0];
        dp[3] = 0;
        for (int i = 1; i < prices.length; i++) {
            int dp0 = dp[0];
            int dp1 = dp[1];
            int dp2 = dp[2];
            dp[0] = Math.max(-prices[i], dp[0]);
            dp[1] = Math.max(dp0 + prices[i], dp[1]);
            dp[2] = Math.max(dp1 - prices[i], dp[2]);
            dp[3] = Math.max(dp2 + prices[i], dp[3]);
        }
        return dp[3];
    }
}
