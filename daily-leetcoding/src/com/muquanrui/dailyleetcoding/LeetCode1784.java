package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/10/3 16:15
 */

/**
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */
public class LeetCode1784 {
    public boolean checkOnesSegment(String s) {
        int left = 0;
        while (left < s.length() && s.charAt(left) == '0') {
            left++;
        }
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == '0') {
            right--;
        }
        while (left < s.length() && right >= 0 && left < right) {
            if (s.charAt(left) == '0' || s.charAt(right) == '0') {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
