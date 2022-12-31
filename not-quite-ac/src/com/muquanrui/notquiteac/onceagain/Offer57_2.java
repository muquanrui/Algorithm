package com.muquanrui.notquiteac.onceagain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/7/20 20:48
 */

/**
 * https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 滑动窗口
 */
public class Offer57_2 {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        int left = 1;
        for (int right = 1; right <= target / 2 + 1; right++) {
            if (sum < target) {
                sum += right;
                list.add(right);
            }
            while (sum >= target) {
                if (sum == target) {
                    resList.add(new ArrayList<>(list));
                }
                sum -= left++;
                list.removeFirst();
            }
        }
        int[][] res = new int[resList.size()][];
        for (int i = 0; i < res.length; i++) {
            int[] tmp = new int[resList.get(i).size()];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = resList.get(i).get(j);
            }
            res[i] = tmp;
        }
        return res;
    }
}
