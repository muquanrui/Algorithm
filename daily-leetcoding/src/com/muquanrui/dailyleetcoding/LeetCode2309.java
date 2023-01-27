package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/27 15:37
 */

public class LeetCode2309 {
    public String greatestLetter(String s) {
        int[] dict = new int[26];
        for (char ch : s.toCharArray()) {
            int i = (ch - 'A') <= 25 ? (ch - 'A') : (ch - 'a');
            if ((dict[i] & 1) == 0 && ch >= 'a' && ch <= 'z') {
                dict[i] += 1;
            } else if ((dict[i] >> 1) == 0 && ch >= 'A' && ch <= 'Z'){
                dict[i] += 2;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (dict[i] == 3) {
                return (char)('A' + i) + "";
            }
        }
        return "";
    }
}
