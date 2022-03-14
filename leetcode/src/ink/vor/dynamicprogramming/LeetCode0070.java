package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 14/03/2022 21:52
 */
public class LeetCode0070 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
