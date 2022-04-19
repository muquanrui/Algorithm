package ink.vor.top101;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/19 22:46
 */
public class BM96 {
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[startEnd.length];
        int[] end = new int[startEnd.length];
        for (int i = 0; i < startEnd.length; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0;
        int e = 0;
        int count = 0;
        int res = 0;
        while (s < start.length) {
            if (start[s] < end[e]) {
                s++;
                count++;
                res = Math.max(res, count);
            } else {
                e++;
                count--;
            }
        }
        return res;
    }
}
