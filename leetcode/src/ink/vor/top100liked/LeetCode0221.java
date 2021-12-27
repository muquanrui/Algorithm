package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 27/12/2021 14:04
 */
public class LeetCode0221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1' ,'1' ,'0'},
                {'1', '1', '0'},
                {'1', '1', '1'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            if (dp[i][0] == 1 && max == 0) {
                max = 1;
            }
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
            if (dp[0][j] == 1 && max == 0) {
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}
