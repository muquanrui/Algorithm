package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 2022/5/9 20:30
 */
public class LeetCode0135 {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i: dp) {
            sum += i;
        }
        return sum;
    }
}
