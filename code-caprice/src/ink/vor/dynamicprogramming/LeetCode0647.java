package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/14 17:43
 */
public class LeetCode0647 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        int res = 0;
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i; j < s.length() + 1; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                        res++;
                        continue;
                    }
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
