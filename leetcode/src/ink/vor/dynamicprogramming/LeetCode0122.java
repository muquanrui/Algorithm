package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 21/03/2022 22:33
 */
public class LeetCode0122 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = prices[i] > prices[i - 1] ? dp[i - 1] + prices[i] - prices[i - 1] : dp[i - 1];
        }
        return dp[prices.length - 1];
    }
}
