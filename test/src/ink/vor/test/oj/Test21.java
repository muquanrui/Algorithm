package ink.vor.test.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/10/9 14:46
 */

public class Test21 {
    public int networkDelayTime (int[][] times, int n, int k) {
        // write code here
        isVisited = new boolean[n];
        map = new HashMap<>();
        timeMap = new HashMap<>();
        for (int[] arr : times) {
            if (map.containsKey(arr[0])) {
                map.get(arr[0]).add(new int[]{arr[1], arr[2]});
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{arr[1], arr[2]});
                map.put(arr[0], list);
            }
        }
        wfs(0, k);
        if (!flag) {
            return -1;
        }
        for (boolean b : isVisited) {
            if (!b) {
                return -1;
            }
        }
        int res = 0;
        for (Integer time : timeMap.values()) {
            res = Math.max(res, time);
        }
        return res;
    }
    boolean[] isVisited;
    Map<Integer, List<int[]>> map;
    Map<Integer, Integer> timeMap;
    boolean flag = true;
    private void wfs(int curTime, int source) {
        if (timeMap.getOrDefault(source, Integer.MAX_VALUE) <= curTime) {
            return;
        }
        timeMap.put(source, curTime);
        if (source >= isVisited.length) {
            flag = false;
            return;
        }
        isVisited[source - 1] = true;
        if (!map.containsKey(source)) {
            return;
        }
        List<int[]> list = map.get(source);
        for (int[] arr : list) {
            wfs(curTime + arr[1], arr[0]);
        }
    }
}
