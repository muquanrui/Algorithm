package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/12 22:03
 */
public class LeetCode0518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
