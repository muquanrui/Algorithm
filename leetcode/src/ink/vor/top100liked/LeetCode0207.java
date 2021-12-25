package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 25/12/2021 07:54
 */
public class LeetCode0207 {
    public Map<Integer, List<Integer>> map;
    public int[] isVisited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        isVisited = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            if (map.get(prerequisites[i][0]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            } else {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == 0 && !dfs(i, new int[isVisited.length])) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int start, int[] path) {
        if (path[start] == 1) {
            return false;
        }
        if (map.get(start) == null) {
            isVisited[start] = 1;
            return true;
        }
        path[start] = 1;
        List<Integer> list = map.get(start);
        for (int i: list) {
            if (isVisited[i] == 0) {
                boolean res = dfs(i, path);
                if (res == false) {
                    return false;
                }
            }
        }
        path[start] = 0;
        isVisited[start] = 1;
        return true;
    }
}
