package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/12/11 05:16
 */

// https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/
public class LeetCode1827 {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }
}
