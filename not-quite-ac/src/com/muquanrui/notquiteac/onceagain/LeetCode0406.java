package com.muquanrui.notquiteac.onceagain;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/28 20:03
 */

/**
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 * 贪心算法
 */
public class LeetCode0406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            } else {
                return p2[0] - p1[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = list.removeFirst();
        }
        return people;
    }
}
