package com.muquanrui.leetcode.dynamicprogramming;

/**
 * @author muquanrui
 * @date 17/03/2022 21:10
 */
public class LeetCode0096 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
