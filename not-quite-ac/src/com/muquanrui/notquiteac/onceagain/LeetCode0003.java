package com.muquanrui.notquiteac.onceagain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/5/29 10:43
 */

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 滑动窗口，双指针
 */
public class LeetCode0003 {
    public int lengthOfLongestSubstring(String s) {
        // 存储出现字符和其最后出现下标
        Map<Character, Integer> map = new HashMap();
        int res = 0;
        // left - right闭区间内是不重复字符的子串
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // 如果出现重复字符，移动left
            if (map.containsKey(ch)) {
                // 两种情况：left移动到重复字符之前出现位置+1；left已经移动到前一情况之后的位置
                // 比如：abba
                left = Math.max(left, map.get(ch) + 1);
            }
            // 更新结果和当前字符最后出现下标
            res = Math.max(res, right - left + 1);
            map.put(ch, right);
        }
        return res;
    }
}
