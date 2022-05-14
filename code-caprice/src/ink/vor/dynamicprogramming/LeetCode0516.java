package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/14 18:16
 */
public class LeetCode0516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i; j < s.length() + 1; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (i == j - 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[1][s.length()];
    }
}
