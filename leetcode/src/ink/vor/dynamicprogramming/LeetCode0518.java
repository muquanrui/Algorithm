package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 19/03/2022 20:56
 */
public class LeetCode0518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
