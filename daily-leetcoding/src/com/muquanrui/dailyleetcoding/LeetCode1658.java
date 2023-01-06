package com.muquanrui.dailyleetcoding;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2023/1/7 02:11
 */

public class LeetCode1658 {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if (target == 0) {
            return nums.length;
        }
        if (target < 0) {
            return -1;
        }
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (sum == target) {
                    ans = Math.min(ans, nums.length - (right - left + 1));
                }
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
