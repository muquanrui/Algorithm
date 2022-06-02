package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/2 13:30
 */

// https://leetcode.cn/problems/spiral-matrix/
public class LeetCode0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        List<Integer> resList = new ArrayList<>();
        while (top < (rows + 1) / 2 && left < (columns + 1) / 2) {
            for (int x = left; x <= right; x++) {
                resList.add(matrix[top][x]);
            }
            for (int y = top + 1; y <= bottom; y++) {
                resList.add(matrix[y][right]);
            }
            for (int x = right - 1; x >= left && top != bottom; x--) {
                resList.add(matrix[bottom][x]);
            }
            for (int y = bottom - 1; y > top && left != right; y--) {
                resList.add(matrix[y][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return resList;
    }
}
