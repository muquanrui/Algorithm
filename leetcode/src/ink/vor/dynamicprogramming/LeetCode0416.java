package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 17/03/2022 22:09
 */
public class LeetCode0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i : nums) {
            for (int j = target; j >= i; j--) {
                dp[j] = dp[j] || dp[j - i];
            }
        }
        return dp[target];
    }
}
