package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/27 15:38
 */

/**
 * https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/
 * 动态规划，dfs
 */
public class LeetCode0329 {
    int[][] dp;
    int res = 1;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            dp[i][j] = dfs(matrix, i, j + 1) + 1;
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i + 1, j) + 1);
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j - 1) + 1);
        }
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i - 1, j) + 1);
        }
        dp[i][j] = Math.max(dp[i][j], 1);
        return dp[i][j];
    }
}
