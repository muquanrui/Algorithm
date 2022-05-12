package ink.vor.dynamicprogramming;

import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/12 22:46
 */
public class LeetCode0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i < word.length()) {
                    continue;
                }
                dp[i] = dp[i] ||
                        (dp[i - word.length()] && s.substring(i - word.length(), i).equals(word));
            }
        }
        return dp[s.length()];
    }
}
