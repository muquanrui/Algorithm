package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/2 18:04
 */

import java.util.*;

/**
 * https://leetcode.cn/problems/fruit-into-baskets/
 * 滑动窗口
 */
public class LeetCode0904 {
    public int totalFruit(int[] fruits) {
        Set<Integer> basket = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (basket.size() < 2 || basket.contains(fruits[i])) {
                basket.add(fruits[i]);
                map.put(fruits[i], i);
                count++;
                res = Math.max(res, count);
                continue;
            }
            int remain = fruits[i - 1];
            int remove = -1;
            for (int f : basket) {
                if (f != remain) {
                    remove = f;
                }
            }
            basket.remove(remove);
            int last = map.remove(remove);
            i--;
            count = i - last;
        }
        return res;
    }
}
