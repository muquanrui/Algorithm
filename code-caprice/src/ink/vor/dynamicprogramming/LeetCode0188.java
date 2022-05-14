package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/14 07:57
 */
public class LeetCode0188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k];
        for (int i = 0; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
            dp[0][i + 1] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            for (int j = 2; j < 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], prices[i] + dp[i - 1][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < 2 * k; i += 2) {
            res = Math.max(res, dp[prices.length - 1][i + 1]);
        }
        return res;
    }
}
