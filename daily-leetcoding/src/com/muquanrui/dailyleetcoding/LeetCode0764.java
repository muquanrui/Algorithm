package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/11/9 15:24
 */

// https://leetcode.cn/problems/largest-plus-sign/description/
public class LeetCode0764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = 1;
            }
        }
        for (int[] arr : mines) {
            matrix[arr[0] + 1][arr[1] + 1] = 0;
        }
        int[][][] prefixSum = new int[n + 2][n + 2][4];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j][0] = matrix[i][j] == 0 ? 0 : prefixSum[i - 1][j][0] + 1;
                prefixSum[i][j][1] = matrix[i][j] == 0 ? 0 : prefixSum[i][j - 1][1] + 1;
            }
        }
        for (int i = n; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                prefixSum[i][j][2] = matrix[i][j] == 0 ? 0 : prefixSum[i + 1][j][2] + 1;
                prefixSum[i][j][3] = matrix[i][j] == 0 ? 0 : prefixSum[i][j + 1][3] + 1;
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, Math.min(Math.min(prefixSum[i][j][0], prefixSum[i][j][1]), Math.min(prefixSum[i][j][2], prefixSum[i][j][3])));
            }
        }
        return max;
    }
}
