package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/17 20:18
 */
public class BM82 {
    public int maxProfit (int[] prices) {
        int[][] dp = new int[2][4];
        // 第一次买入并持有
        dp[0][0] = -prices[0];
        // 第一次卖出
        dp[0][1] = 0;
        // 第二次买入并持有
        dp[0][2] = -prices[0];
        // 第二次卖出
        dp[0][3] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[1][0] = Math.max(-prices[i], dp[0][0]);
            dp[1][1] = Math.max(dp[0][0] + prices[i], dp[0][1]);
            dp[1][2] = Math.max(dp[0][1] - prices[i], dp[0][2]);
            dp[1][3] = Math.max(dp[0][2] + prices[i], dp[0][3]);
            dp[0] = dp[1];
        }
        return dp[0][3];
    }
}
