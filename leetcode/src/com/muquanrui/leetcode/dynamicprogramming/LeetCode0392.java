package com.muquanrui.leetcode.dynamicprogramming;

/**
 * @author muquanrui
 * @date 27/03/2022 18:22
 */
public class LeetCode0392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int indexS = 0;
        for (char ch : t.toCharArray()) {
            if (ch == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
