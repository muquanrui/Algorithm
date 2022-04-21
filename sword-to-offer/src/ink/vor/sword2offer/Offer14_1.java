package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:53
 */
public class Offer14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n];
        dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i - 1] = Math.max(dp[i - 1], Math.max(j * (i - j), j * dp[i - j - 1]));
            }
        }
        return dp[n - 1];
    }
}
