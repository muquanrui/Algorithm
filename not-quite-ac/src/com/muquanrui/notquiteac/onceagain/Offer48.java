package com.muquanrui.notquiteac.onceagain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/7/19 13:32
 */

/**
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * 滑动窗口，Hash
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch) || map.get(ch) < left) {
                res = Math.max(res, right - left + 1);
            } else {
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
        }
        return res;
    }
}
