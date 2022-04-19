package ink.vor.top101;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author muquanrui
 * @date 2022/4/19 22:43
 */
public class BM89 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> resList = new ArrayList<>();
        if (intervals.size() == 0) {
            return resList;
        }
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        resList.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = resList.get(resList.size() - 1);
            Interval cur = intervals.get(i);
            if (pre.end < cur.start) {
                resList.add(cur);
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        return resList;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
