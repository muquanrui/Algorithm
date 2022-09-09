package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/12 17:35
 */

/**
 * https://leetcode.cn/problems/distinct-subsequences/
 * 动态规划
 */
public class LeetCode0115 {
    public int numDistinct(String s, String t) {
        // 下标i、j表示：s到i-1的子串中包含t到j-1的子串个数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 初始化：t为空串时，s的i-1的子串包含空串的个数为1
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // 当前字符相等：使用s在i-1位置的字符匹配即dp[i - 1][j - 1]；不使用s在i-1位置的字符匹配即dp[i - 1][j]
                // 此时的结果是两者之和
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 不相等时只能不使用s在i-1位置的字符匹配即dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
