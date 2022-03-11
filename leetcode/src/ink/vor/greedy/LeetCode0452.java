package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 11/03/2022 22:23
 */
public class LeetCode0452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, ((o1, o2) -> {
            long res;
            if (o1[0] == o2[0]) {
                res = (long)o1[1] - (long)o2[1];
            } else {
                res = (long)o1[0] - (long)o2[0];
            }
            if (res < 0) {
                return -1;
            } else if (res > 0) {
                return 1;
            } else {
                return 0;
            }
        }));
        int arrows = 1;
        int curBound = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (curBound < points[i][0]) {
                arrows++;
                curBound = points[i][1];
            }
            if (curBound > points[i][1]) {
                curBound = points[i][1];
            }
        }
        return arrows;
    }
}
