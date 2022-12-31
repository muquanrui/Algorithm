package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/14 14:54
 */

/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 * 动态规划
 */
public class LeetCode0152 {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
