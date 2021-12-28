package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 28/12/2021 21:27
 */
public class LeetCode0210 {
    public Map<Integer, List<Integer>> map;
    public boolean[] isVisited;
    public List<Integer> resList;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        isVisited = new boolean[numCourses];
        resList = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (map.get(prerequisites[i][0]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            } else {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                boolean res = dfs(i, new boolean[numCourses], 0);
                if (!res) {
                    return new int[]{};
                }
            }
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < order.length; i++) {
            order[i] = resList.get(i);
        }
        return order;
    }

    public boolean dfs(int i, boolean[] path, int level) {
        if (path[i] == true) {
            return false;
        }
        if (isVisited[i] == true) {
            return true;
        }

        isVisited[i] = true;

        List<Integer> list = map.get(i);

        if (list == null) {
            resList.add(i);
            return true;
        }

        path[i] = true;

        for (int temp: list) {
            boolean res = dfs(temp, path, level + 1);
            if (!res) {
                return false;
            }
        }

        resList.add(i);

        path[i] = false;
        return true;
    }
}
