package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/15 17:44
 */
public class BM66 {
    public String LCS (String str1, String str2) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        String res = "";
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                dp[i][j] = "";
            }
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                    if (res.length() < dp[i][j].length()) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res;
    }
}
