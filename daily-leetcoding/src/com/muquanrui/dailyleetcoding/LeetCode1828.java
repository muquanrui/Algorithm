package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/24 13:16
 */

public class LeetCode1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int radius = queries[i][2];
            for (int[] point : points) {
                double dist = (x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]);
                if (Math.sqrt(dist) <= radius) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}
