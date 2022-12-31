package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/29 16:46
 */

/**
 * https://leetcode.cn/problems/ones-and-zeroes/
 * 动态规划，背包问题
 */
public class LeetCode0474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dict = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (char ch : strs[i].toCharArray()) {
                if (ch == '0') {
                    dict[i][0]++;
                } else {
                    dict[i][1]++;
                }
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int[] s : dict) {
            for (int i = m; i >= s[0]; i--) {
                for (int j = n; j >= s[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - s[0]][j - s[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
