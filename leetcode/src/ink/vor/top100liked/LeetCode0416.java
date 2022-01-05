package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 05/01/2022 17:25
 */
public class LeetCode0416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}
