package com.muquanrui.notquiteac.onceagain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/18 14:58
 */

/**
 * https://leetcode.cn/problems/course-schedule/
 * 图，DFS
 */
public class LeetCode0207 {
    List<List<Integer>> adjacency;
    boolean[] visit;
    boolean[] finish;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacency = new ArrayList<>();
        visit = new boolean[numCourses];
        finish = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adjacency.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (finish[i] || dfs(i)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean dfs(int course) {
        List<Integer> preCourses = adjacency.get(course);
        visit[course] = true;
        for (int i : preCourses) {
            if (!visit[i] && (finish[i] || dfs(i))) {
                continue;
            }
            return false;
        }
        visit[course] = false;
        finish[course] = true;
        return true;
    }
}
