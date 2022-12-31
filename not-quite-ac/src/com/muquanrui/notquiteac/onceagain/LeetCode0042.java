package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/1 16:35
 */

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * 单调栈
 */
public class LeetCode0042 {
    public int trap(int[] height) {
        // 寻找当前柱子左侧最高的柱子
        int[] maxLeft = new int[height.length];
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        // 寻找当前柱子右侧最高的柱子
        int[] maxRight = new int[height.length];
        max = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, height[i]);
        }
        int res = 0;
        // 当前柱子能容纳的雨水 = Math.min(当前柱子左侧最高的柱子, 当前柱子右侧最高的柱子) - 当前柱子高度
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) > height[i] ? Math.min(maxLeft[i], maxRight[i]) - height[i] : 0;
        }
        return res;
    }
}
