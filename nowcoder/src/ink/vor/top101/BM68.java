package ink.vor.top101;

import java.util.ArrayList;

/**
 * @author muquanrui
 * @date 2022/4/16 20:13
 */
public class BM68 {
    public int minPathSum (int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + matrix[i][j];
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }
}
