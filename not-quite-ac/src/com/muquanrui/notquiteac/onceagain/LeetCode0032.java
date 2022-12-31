package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/1 13:35
 */

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/
 * 动态规划
 */
public class LeetCode0032 {
    public int longestValidParentheses(String s) {
        int res = 0;
        // 下标表示截止到当前位置（使用当前位置元素）连续的有效括号长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            // 当前是左括号：直接为0
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                // 当前是右括号：
                // 前一位是左括号：两位前的长度 + 2
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else {
                    // 前一位是右括号：倒退至前一位-有效长度位置，如果该位置是左括号，则为该位置前一位的有效长度+当前位置前一位的有效长度+2，如果不是左括号直接为0
                    int pre = i - 1 - dp[i - 1];
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        dp[i] = pre > 0 ? dp[pre - 1] + dp[i - 1] + 2 : dp[i - 1] + 2;
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
