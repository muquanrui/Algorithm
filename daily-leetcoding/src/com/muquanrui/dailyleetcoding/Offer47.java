package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/3/8 22:25
 */

public class Offer47 {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i - 1][j - 1], dp[i][j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
