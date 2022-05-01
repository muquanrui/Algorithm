package ink.vor.array;

/**
 * @author muquanrui
 * @date 2022/5/1 17:00
 */
public class LeetCode0059 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        for (int circle = 0; circle < (n + 1) / 2; circle++) {
            for (int x = left; x <= right; x++) {
                matrix[top][x] = num;
                num++;
            }
            for (int y = top + 1; y <= bottom; y++) {
                matrix[y][right] = num;
                num++;
            }
            for (int x = right - 1; x >= left && top != bottom; x--) {
                matrix[bottom][x] = num;
                num++;
            }
            for (int y = bottom -1; y >= top + 1 && left != right; y--) {
                matrix[y][left] = num;
                num++;
            }
            top += 1;
            bottom -= 1;
            left += 1;
            right -= 1;
        }
        return matrix;
    }
}
