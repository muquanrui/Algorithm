package com.muquanrui.notquiteac.onceagain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/28 19:14
 */

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * HashMap，滑动窗口
 */
public class LeetCode0438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] dict = new int[26];
        for (char ch : p.toCharArray()) {
            dict[ch - 'a']++;
        }
        List<Integer> resList = new ArrayList<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            dict[ch - 'a']--;
            if (dict[ch - 'a'] >= 0) {
                count++;
            }
            while (count == p.length()) {
                if (right - left + 1 == p.length()) {
                    resList.add(left);
                }
                dict[s.charAt(left) - 'a']++;
                if (dict[s.charAt(left) - 'a'] > 0) {
                    count--;
                }
                left++;
            }

        }
        return resList;
    }
}
