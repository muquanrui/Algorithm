package com.muquanrui.dailyleetcoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2022/11/11 13:21
 */

// https://leetcode.cn/problems/determine-if-string-halves-are-alike/
public class LeetCode1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowel = new HashSet<>();
        vowel.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int mid = s.length() / 2;
        int count = 0;
        for (int i = 0; i < mid; i++) {
            char ch = s.charAt(i);
            if (vowel.contains(ch)) {
                count++;
            }
        }
        for (int i = mid; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowel.contains(ch)) {
                count--;
            }
        }
        return count == 0;
    }
}
