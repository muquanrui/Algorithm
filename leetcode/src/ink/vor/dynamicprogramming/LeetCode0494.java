package ink.vor.dynamicprogramming;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 18/03/2022 19:19
 */
public class LeetCode0494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = left; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[left];
    }
}
