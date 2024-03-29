package com.muquanrui.codecaprice.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/5/2 12:03
 */
public class LeetCode0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int num = nums1[i] + nums2[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int target = 0 - nums3[i] - nums4[j];
                if (map.containsKey(target)) {
                    res += map.get(target);
                }
            }
        }
        return res;
    }
}
