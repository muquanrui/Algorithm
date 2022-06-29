package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/29 16:46
 */
public class LeetCode0474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dict = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int count0 = 0;
            int count1 = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            dict[i][0] = count0;
            dict[i][1] = count1;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int[] s : dict) {
            for (int i = m; i >= s[0]; i--) {
                for (int j = n; j >= s[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - s[0]][j - s[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
