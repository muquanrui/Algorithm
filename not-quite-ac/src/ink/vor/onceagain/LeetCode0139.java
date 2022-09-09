package ink.vor.onceagain;

import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/13 13:06
 */

/**
 * https://leetcode.cn/problems/word-break/
 * 动态规划，背包问题
 */
public class LeetCode0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() > i) {
                    continue;
                }
                if (word.equals(s.substring(i - word.length(), i))) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }
        return dp[s.length()];
    }
}
