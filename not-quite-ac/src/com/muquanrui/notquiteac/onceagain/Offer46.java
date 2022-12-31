package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/18 22:04
 */

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 动态规划
 */
public class Offer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 2) != '0') {
                int n = Integer.parseInt(s.substring(i - 2, i));
                if (n >= 10 && n <= 25) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
