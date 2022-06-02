package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/2 12:00
 */

// https://leetcode.cn/problems/rotate-image/
public class LeetCode0048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] ^= matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[n - 1 - i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }

    // public int[][] rotateMatrix(int[][] mat, int n) {
    //     int top = 0;
    //     int bottom = n - 1;
    //     int left = 0;
    //     int right = n - 1;
    //     for (int i = 0; i < n / 2; i++) {
    //         for (int x = left; x < right; x++) {
    //             int temp = mat[top][x];
    //             int diff = x - left;
    //             mat[top][x] = mat[bottom - diff][left];
    //             mat[bottom - diff][left] = mat[bottom][right - diff];
    //             mat[bottom][right - diff] = mat[top + diff][right];
    //             mat[top + diff][right] = temp;
    //         }
    //         top++;
    //         bottom--;
    //         left++;
    //         right--;
    //     }
    //     return mat;
    // }
}
