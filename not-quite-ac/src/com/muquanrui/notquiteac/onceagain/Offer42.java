package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/18 11:50
 */

/**
 * https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 贪心，动态规划
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
            } else {
                sum = Math.max(sum + nums[i], nums[i]);
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
