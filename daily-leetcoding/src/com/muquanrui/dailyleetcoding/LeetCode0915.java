package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2022/10/24 19:59
 */

public class LeetCode0915 {
    public int partitionDisjoint(int[] nums) {
        int left = 0;
        int max = nums[left];
        while (left < nums.length) {
            int right = left + 1;
            int nextMax = max;
            for (; right < nums.length; right++) {
                if (max > nums[right]) {
                    left = right;
                    break;
                }
                nextMax = Math.max(nextMax, nums[right]);
            }
            if (right == nums.length) {
                return left + 1;
            }
            max = nextMax;
        }
        return nums.length;
    }
}
