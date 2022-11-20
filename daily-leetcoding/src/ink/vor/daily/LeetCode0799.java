package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/11/20 14:55
 */

// https://leetcode.cn/problems/champagne-tower/
public class LeetCode0799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] < 1) {
                    continue;
                }
                dp[i + 1][j] = (dp[i][j] - 1) / 2;
                dp[i + 1][j + 1] = (dp[i][j] - 1) / 2;
            }
        }
        return dp[query_row][query_glass] > 1 ? 1 : dp[query_row][query_glass];
    }
}
