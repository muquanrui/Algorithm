package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/9 13:55
 */

public class LeetCode1806 {
    public int reinitializePermutation(int n) {
        int i = 1;
        int ans = 0;
        do {
            if (i < n / 2) {
                i *= 2;
            } else {
                i = i * 2 - n + 1;
            }
            ans++;
        } while (i != 1);
        return ans;
    }
}
