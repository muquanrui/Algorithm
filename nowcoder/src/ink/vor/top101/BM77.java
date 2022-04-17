package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/17 20:17
 */
public class BM77 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else {
                    int j = i - 1 - dp[i - 1];
                    if (j > -1 && s.charAt(j) == '(') {
                        dp[i] = j > 0 ? dp[j - 1] + dp[i - 1] + 2 : dp[i - 1] + 2;
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
