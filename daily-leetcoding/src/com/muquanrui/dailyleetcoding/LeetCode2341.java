package com.muquanrui.dailyleetcoding;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2023/2/16 00:59
 */

public class LeetCode2341 {
    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int pairs = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                pairs++;
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return new int[]{pairs, nums.length - pairs * 2};
    }
}
