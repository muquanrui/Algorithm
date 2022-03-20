package ink.vor.dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 20/03/2022 16:12
 */
public class LeetCode0279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j * j <= i; j++) {
        //         dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        //     }
        // }
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}