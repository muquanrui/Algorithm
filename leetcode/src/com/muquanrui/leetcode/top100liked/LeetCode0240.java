package com.muquanrui.leetcode.top100liked;

/**
 * @author muquanrui
 * @date 30/12/2021 15:05
 */
public class LeetCode0240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

}
