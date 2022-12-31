package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/1 00:26
 */

public class LeetCode2351 {
    public char repeatedCharacter(String s) {
        boolean[] dict = new boolean[26];
        for (char ch : s.toCharArray()) {
            if (dict[ch - 'a']) {
                return ch;
            }
            dict[ch - 'a'] = true;
        }
        return 'a';
    }
}
