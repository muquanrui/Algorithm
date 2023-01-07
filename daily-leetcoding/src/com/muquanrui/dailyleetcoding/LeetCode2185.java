package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/8 00:03
 */

public class LeetCode2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.length() < pref.length()) {
                continue;
            }
            if (word.substring(0, pref.length()).equals(pref)) {
                ans++;
            }
        }
        return ans;
    }
}
