package com.muquanrui.notquiteac.onceagain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/22 19:26
 */

/**
 * https://leetcode.cn/problems/perfect-squares/submissions/
 * 动态规划，背包问题
 */
public class LeetCode0279 {
    public int numSquares(int n) {
        List<Integer> items = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            items.add(i * i);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int num : items) {
            for (int i = num; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - num] + 1);
            }
        }
        return dp[n];
    }
}
