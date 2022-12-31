package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/5/29 12:17
 */

/**
 * https://leetcode.cn/problems/regular-expression-matching/
 * 动态规划
 */
public class LeetCode0010 {
    public boolean isMatch(String s, String p) {
        // 开dp，确定下标含义，dp[i][j]表示s到位置i - 1是否匹配p到位置j - 1
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化下标
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        // 遍历递推，先遍历s，再遍历p
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // p的j - 1位置为*：不使用前面的元素；使用前面的元素
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    // p的j - 1位置不为*：前一个元素匹配，当前元素相等，或p的元素为.
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}