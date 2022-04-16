package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/16 20:35
 */
public class BM73 {
    public int getLongestPalindrome (String A) {
        int[][] dp = new int[A.length()][A.length()];
        for (int i = 0; i < A.length(); i++) {
            dp[i][i] = 1;
        }
        int res = 1;
        for (int i = A.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (dp[i + 1][j - 1] == 0 && i + 1 < j - 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
