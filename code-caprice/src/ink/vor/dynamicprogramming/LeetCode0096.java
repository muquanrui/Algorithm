package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/12 09:13
 */
public class LeetCode0096 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
