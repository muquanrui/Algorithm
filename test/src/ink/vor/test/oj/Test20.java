package ink.vor.test.oj;

/**
 * @author muquanrui
 * @date 2022/10/9 14:35
 */

public class Test20 {
    public int maximumTotal (int[][] triangle) {
        if (triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }
        // write code here
        return fall(triangle, 0, 0);
    }
    private int fall(int[][] triangle, int row, int column) {
        if (row == triangle.length) {
            return 0;
        }
        int left = fall(triangle, row + 1, column);
        int right = fall(triangle, row + 1, column + 1);
        return Math.max(left, right) + triangle[row][column];
    }
}
