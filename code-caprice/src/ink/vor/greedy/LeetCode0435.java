package ink.vor.greedy;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/5/11 16:55
 */
public class LeetCode0435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0],interval2[0]));
        int removes = 0;
        int edge = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (edge > intervals[i][0]) {
                removes++;
                edge = Math.min(edge, intervals[i][1]);
            } else {
                edge = intervals[i][1];
            }
        }
        return removes;
    }
}
