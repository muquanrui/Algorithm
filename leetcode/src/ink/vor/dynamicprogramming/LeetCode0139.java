package ink.vor.dynamicprogramming;

import java.util.List;

/**
 * @author muquanrui
 * @date 20/03/2022 16:37
 */
public class LeetCode0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    dp[i] = dp[i - word.length()] && s.substring(i- word.length(), i).equals(word);
                    if (dp[i] == true) {
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}