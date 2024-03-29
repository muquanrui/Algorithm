package com.muquanrui.codecaprice.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/12 11:45
 */
public class LeetCode0494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum + target) % 2 == 1 || sum < Math.abs(target)) {
            return 0;
        }
        target = (sum + target) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = target; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        return dp[target];
    }
}
