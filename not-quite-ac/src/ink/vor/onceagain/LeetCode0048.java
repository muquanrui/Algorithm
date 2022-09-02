package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/2 12:00
 */

/**
 * https://leetcode.cn/problems/rotate-image/
 * 二维数组模拟
 */
public class LeetCode0048 {
    public void rotate(int[][] matrix) {
        // 对角线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        // 每一行反转
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                matrix[i][left] ^= matrix[i][right];
                matrix[i][right] ^= matrix[i][left];
                matrix[i][left] ^= matrix[i][right];
                left++;
                right--;
            }
        }
    }
}
