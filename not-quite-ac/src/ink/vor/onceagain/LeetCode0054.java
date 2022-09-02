package ink.vor.onceagain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/2 13:30
 */

/**
 * https://leetcode.cn/problems/spiral-matrix/
 * 二维数组模拟
 */
public class LeetCode0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        // 大循环次数：top和left都不能超过行数和列数的中点
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            for (int i = right - 1; i >= left && top != bottom; i--) {
                list.add(matrix[bottom][i]);
            }
            for (int i = bottom - 1; i >= top + 1 && left != right; i--) {
                list.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }
}
