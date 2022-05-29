package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/5/29 12:17
 */

// https://leetcode.cn/problems/regular-expression-matching/
public class LeetCode0010 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                int charS = s.charAt(i - 1);
                int charP = p.charAt(j - 1);
                if (charS == charP || charP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            dp[i - 1][j] && (p.charAt(j - 2) == charS || p.charAt(j - 2) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}