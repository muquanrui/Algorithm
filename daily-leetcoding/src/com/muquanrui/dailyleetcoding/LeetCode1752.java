package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/11/27 02:30
 */

// https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
public class LeetCode1752 {
    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
            if (flag && nums[i] > nums[0]) {
                return false;
            }
        }
        return true;
    }
}
