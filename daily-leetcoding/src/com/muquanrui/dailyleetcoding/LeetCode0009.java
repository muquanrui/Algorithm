package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/1/1 01:11
 */

public class LeetCode0009 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
