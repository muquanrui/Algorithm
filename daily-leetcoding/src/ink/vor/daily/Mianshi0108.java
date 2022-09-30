package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/9/30 21:01
 */

/**
 * https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class Mianshi0108 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] isVisited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!isVisited[i][j] && matrix[i][j] == 0) {
                    clear(matrix, isVisited, i, j);
                }
            }
        }
    }

    private void clear(int[][] matrix, boolean[][] isVisited, int y, int x) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][x] == 0) {
                continue;
            }
            isVisited[i][x] = true;
            matrix[i][x] = 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[y][j] == 0) {
                continue;
            }
            isVisited[y][j] = true;
            matrix[y][j] = 0;
        }
    }
}
