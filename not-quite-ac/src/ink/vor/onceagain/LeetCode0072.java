package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/3 15:56
 */

/**
 * https://leetcode.cn/problems/edit-distance/
 * 动态规划
 */
public class LeetCode0072 {
    public int minDistance(String word1, String word2) {
        // 下标ij表示word1到下标i-1的子串转换为word2到下标j-1的子串所需要的最少操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符相等
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 字符不相等
                    // 插入/删除一个字符; 替换一个字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
