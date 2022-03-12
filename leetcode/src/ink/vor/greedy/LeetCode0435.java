package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 12/03/2022 14:12
 */
public class LeetCode0435 {
    // [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
    // [[-73,-26],[-65,-11],[-63,2],[-62,-49],[-52,31],[-40,-26],[-31,49],[30,47],[58,95],[66,98],[82,97],[95,99]]
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        }));
        int count = 0;
        int bound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (bound > intervals[i][0]) {
                count++;
            } else {
                bound = intervals[i][1];
            }
        }
        return count;
    }
}
