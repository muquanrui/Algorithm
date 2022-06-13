package ink.vor.notquiteac;

import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/13 13:06
 */
public class LeetCode0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i < word.length()) {
                    continue;
                }
                dp[i] = dp[i] || (word.equals(s.substring(i - word.length(), i)) && dp[i - word.length()]);
            }
        }
        return dp[s.length()];
    }
}
