package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/12/21 01:39
 */

public class LeetCode1753 {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxVal = Math.max(Math.max(a, b), c);
        return Math.min(sum - maxVal, sum / 2);
    }
}
