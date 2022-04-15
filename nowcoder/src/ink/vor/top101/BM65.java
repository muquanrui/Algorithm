package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/15 17:28
 */
public class BM65 {
    public String LCS (String s1, String s2) {
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i][0] = "";
        }
        for (int j = 1; j < s2.length() + 1; j++) {
            dp[0][j] = "";
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()].length() == 0 ? "-1" : dp[s1.length()][s2.length()];
    }
}
