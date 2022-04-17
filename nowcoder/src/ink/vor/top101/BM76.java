package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/17 20:16
 */
public class BM76 {
    public boolean match (String str, String pattern) {
        return isMatch(str, pattern);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            (i > 0 &&
                                    dp[i - 1][j] &&
                                    (s.charAt(i - 1) == p.charAt(j - 2) ||
                                            p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] &&
                            (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
