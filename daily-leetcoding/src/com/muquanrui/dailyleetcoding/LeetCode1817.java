package com.muquanrui.dailyleetcoding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2023/1/20 15:36
 */

public class LeetCode1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int minute = log[1];
            if (!map.containsKey(id)) {
                Set<Integer> set = new HashSet<>();
                map.put(id, set);
            }
            map.get(id).add(minute);
        }
        int[] ans = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int count = entry.getValue().size();
            ans[count - 1]++;
        }
        return ans;
    }
}
