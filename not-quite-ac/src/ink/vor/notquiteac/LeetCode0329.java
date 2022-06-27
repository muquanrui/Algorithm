package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/27 15:38
 */
public class LeetCode0329 {
    int[][] dp;
    int res;
    public int longestIncreasingPath(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] == 0) {
                    dfs(matrix, i, j);
                }
            }
        }
        return res + 1;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int cur = matrix[i][j];
        if (i < matrix.length - 1 && matrix[i + 1][j] < cur) {
            dp[i][j] = dfs(matrix, i + 1, j) + 1;
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] < cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j + 1) + 1);
        }
        if (i > 0 && matrix[i - 1][j] < cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i - 1, j) + 1);
        }
        if (j > 0 && matrix[i][j - 1] < cur) {
            dp[i][j] = Math.max(dp[i][j], dfs(matrix, i, j - 1) + 1);
        }
        res = Math.max(res, dp[i][j]);
        return dp[i][j];
    }
}
