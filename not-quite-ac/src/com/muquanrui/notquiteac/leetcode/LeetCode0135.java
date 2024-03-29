package com.muquanrui.notquiteac.leetcode;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/6/13 12:52
 */
public class LeetCode0135 {
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i  + 1] + 1);
            }
        }
        int res = 0;
        for (int i : dp) {
            res += i;
        }
        return res;
    }
}
