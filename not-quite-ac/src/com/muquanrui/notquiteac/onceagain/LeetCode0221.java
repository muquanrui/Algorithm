package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/20 14:54
 */

/**
 * https://leetcode.cn/problems/maximal-square/
 * 动态规划
 */
public class LeetCode0221 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}