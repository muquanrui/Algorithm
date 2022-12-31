package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/22 10:02
 */

/**
 * https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
 * 动态规划
 */
public class Offer60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j <= 5; j++) {
                int index = j;
                for (double d : dp) {
                    tmp[index++] += d / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
