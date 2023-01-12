package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2023/1/13 00:05
 */

public class LeetCode2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] dict = new int[26];
        for (char ch : target.toCharArray()) {
            dict[ch - 'a']++;
        }
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            if (dict[ch - 'a'] > 0) {
                count[ch - 'a']++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (dict[i] > 0) {
                ans = Math.min(ans, count[i] / dict[i]);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
