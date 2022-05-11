package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/5/11 14:37
 */
public class LeetCode0452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (point1, point2) -> {
            return Integer.compare(point1[0], point2[0]);
        });
        int arrows = 1;
        int edge = points[0][1];
        for (int i =  1; i < points.length; i++) {
            if (points[i][0] <= edge) {
                edge = Math.min(edge, points[i][1]);
            } else {
                arrows++;
                edge = points[i][1];
            }
        }
        return arrows;
    }
}
