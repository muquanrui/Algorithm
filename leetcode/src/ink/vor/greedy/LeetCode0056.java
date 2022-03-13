package ink.vor.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 13/03/2022 14:48
 */
public class LeetCode0056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(intervals[0]);
        int bound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (bound >= intervals[i][0]) {
                bound = Math.max(bound, intervals[i][1]);
                list.getLast()[1] = bound;
            } else {
                bound = intervals[i][1];
                list.addLast(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
