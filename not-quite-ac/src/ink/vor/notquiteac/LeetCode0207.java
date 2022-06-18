package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/18 14:58
 */
public class LeetCode0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList());
        }
        for (int[] arr : prerequisites) {
            adjacency.get(arr[0]).add(arr[1]);
        }
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0 && !dfs(adjacency, visit, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency, int[] visit, int i) {
        visit[i] = 1;
        List<Integer> pres = adjacency.get(i);
        for (int pre : pres) {
            if (visit[pre] == 1 || (visit[pre] == 0 && !dfs(adjacency, visit, pre))) {
                return false;
            }
        }
        visit[i] = 2;
        return true;
    }
}
