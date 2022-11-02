package ink.vor.daily;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/11/2 22:54
 */

// https://leetcode.cn/problems/coordinate-with-maximum-network-quality/
public class LeetCode1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int minX = towers[0][0];
        int maxX = towers[0][0];
        int minY = towers[0][1];
        int maxY = towers[0][1];
        for (int i = 1; i < towers.length; i++) {
            minX = Math.min(towers[i][0], minX);
            maxX = Math.max(towers[i][0], maxX);
            minY = Math.min(towers[i][1], minY);
            maxY = Math.max(towers[i][1], maxY);
        }
        int[] res = new int[2];
        int maxSignalSum = 0;
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                int curSignalSum = 0;
                for (int i = 0; i < towers.length; i++) {
                    double dist = Math.sqrt(Math.pow(x - towers[i][0], 2) + Math.pow(y - towers[i][1], 2));
                    if (dist <= radius) {
                        curSignalSum += towers[i][2] / (1 + dist);
                    }
                }
                if (curSignalSum > maxSignalSum) {
                    maxSignalSum = curSignalSum;
                    res[0] = x;
                    res[1] = y;
                }
            }
        }
        return res;
    }
}
