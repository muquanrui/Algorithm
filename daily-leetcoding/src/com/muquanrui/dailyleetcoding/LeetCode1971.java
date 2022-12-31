package com.muquanrui.dailyleetcoding;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/12/19 19:36
 */

public class LeetCode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                map.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            }
            if (map.containsKey(edge[1])) {
                map.get(edge[1]).add(edge[0]);
            } else {
                map.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        queue.offer(source);
        isVisited[source] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> list = map.get(cur);
                for (int num : list) {
                    if (isVisited[num]) {
                        continue;
                    }
                    if (num == destination) {
                        return true;
                    }
                    queue.push(num);
                    isVisited[num] = true;
                }
            }
        }

        return false;
    }
}
