package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/15 16:21
 */
public class BM61 {
    public int solve (int[][] matrix) {
        return longestIncreasingPath(matrix);
    }

    int[][] dp;
    int[][] m;
    int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix;
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }
        return res + 1;
    }

    private int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int cur = m[i][j];
        if (i > 0 && m[i - 1][j] > cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(i - 1, j) + 1);
        }
        if (j > 0 && m[i][j - 1] > cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(i, j - 1) + 1);
        }
        if (i < m.length - 1 && m[i + 1][j] > cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(i + 1, j) + 1);
        }
        if (j < m[0].length - 1 && m[i][j + 1] > cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(i, j + 1) + 1);
        }
        res = Math.max(res, dp[i][j]);
        return dp[i][j];
    }
}
