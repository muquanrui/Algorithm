package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 24/03/2022 23:49
 */
public class LeetCode0674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
