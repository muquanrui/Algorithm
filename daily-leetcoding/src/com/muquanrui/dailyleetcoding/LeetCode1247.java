package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/2/25 11:09
 */

public class LeetCode1247 {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == ch2) {
                continue;
            }
            if (ch1 == 'x') {
                xy++;
            } else {
                yx++;
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}
