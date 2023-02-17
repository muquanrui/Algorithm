package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/2/17 17:33
 */

public class LeetCode1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int[][][] dp = new int[grid.length + 1][grid[0].length + 1][2];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int num = grid[i - 1][j - 1];
                dp[i][j][0] = num == 0 ? 0 : dp[i - 1][j][0] + 1;
                dp[i][j][1] = num == 0 ? 0 : dp[i][j - 1][1] + 1;
            }
        }

        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int max = Math.min(dp[i][j][0], dp[i][j][1]);
                for (int side = max; side > 0; side--) {
                    if (dp[i - side + 1][j][1] >= side && dp[i][j - side + 1][0] >= side) {
                        ans = Math.max(ans, side);
                        break;
                    }
                }
            }
        }

        return ans * ans;
    }
}
