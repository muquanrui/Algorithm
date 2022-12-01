package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/12/1 02:26
 */

// https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
public class LeetCode1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int dist = Math.abs(point[0] - x) + Math.abs(point[1] - y);
                if (dist < min) {
                    res = i;
                    min = dist;
                }
            }
        }
        return res;
    }
}
