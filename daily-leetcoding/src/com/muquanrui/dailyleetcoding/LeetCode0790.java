package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/11/12 12:08
 */

public class LeetCode0790 {
    public int numTilings(int n) {
        final int MOD = 1000000007;
        int[][] dp = new int[n][4];
        dp[0][0] = 1;
        dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n - 1][3];
    }
}
