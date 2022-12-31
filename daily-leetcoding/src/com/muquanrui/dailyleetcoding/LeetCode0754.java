package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/11/4 14:03
 */

// https://leetcode.cn/problems/reach-a-number/
public class LeetCode0754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = (int) Math.sqrt(2 * target);
        int dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;
    }
}
