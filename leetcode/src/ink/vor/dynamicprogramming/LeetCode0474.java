package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 19/03/2022 20:26
 */
public class LeetCode0474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int count0 = 0;
            int count1 = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
