package com.muquanrui.codecaprice.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/14 15:22
 */
public class LeetCode0053 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
