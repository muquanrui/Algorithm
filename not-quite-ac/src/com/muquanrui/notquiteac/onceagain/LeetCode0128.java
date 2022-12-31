package com.muquanrui.notquiteac.onceagain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/6/12 18:09
 */

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 * HashSet
 */
public class LeetCode0128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
